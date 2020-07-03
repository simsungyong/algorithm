package back4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem4485 {
    static int arr[][];
    static int road[][];
    static int moveX[]={0,1,-1,0};
    static int moveY[]={1,0,0,-1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n==0) break;
            cnt++;

            arr= new int[n][n];
            road= new int[n][n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++){
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    road[i][k] = Integer.MAX_VALUE;
                }
            }

            int ans = findload();
            System.out.println("Problem "+cnt+": "+ans);





        }

    }

    public static int findload(){
        PriorityQueue<Prior> q = new PriorityQueue<>();
        q.add(new Prior(0,0,arr[0][0]));
        road[0][0] = arr[0][0];
        while(!q.isEmpty()){
            Prior node = q.poll();
            for(int i=0; i<4; i++){
                int newX = node.x+moveX[i];
                int newY = node.y+moveY[i];
                if(newX<0 || newX>= n || newY<0 || newY>=n){
                    continue;
                }else{
                    if(road[newX][newY] > road[node.x][node.y]+arr[newX][newY]){
                        road[newX][newY] = road[node.x][node.y]+arr[newX][newY];
                        q.add(new Prior(newX,newY,road[newX][newY]));
                    }
                }
            }
        }
        return road[n-1][n-1];

    }


}

class Prior implements Comparable<Prior>{
    int x, y, value;
    Prior(int x, int y, int value){
        this.x=x;
        this.y= y;
        this.value = value;
    }
    @Override
    public int compareTo(Prior o) {
        return this.value-o.value;
//        if(this.value < o.value){
//            return -1;
//        }
//        return 1;
    }//오름차순
}
