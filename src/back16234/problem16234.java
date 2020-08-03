package back16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem16234 {
    static int arr[][];
    static int n,small,big;
    static int moveX[]={1,-1,0,0};
    static int moveY[]={0,0,1,-1};
    static boolean isCon = false;
    static boolean check[][];
    static int temp[][];
    static Queue<Node> q = new LinkedList<>();
    static int teamnum=0;
    static int teamnum_sum=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        small = Integer.parseInt(st.nextToken());
        big = Integer.parseInt(st.nextToken());



        arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;

        while(true){
            temp = new int[n][n];
            isCon = false;
            check = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int k=0; k<n; k++){
                    teamnum=0;
                    teamnum_sum=0;
                    if(!check[i][k]){
                        bfs(i,k);

                        if(q.size()>1){
                            isCon = true;

                        }
                        int newV = teamnum_sum/teamnum;

                        while(!q.isEmpty()){
                            Node node = q.poll();
                            temp[node.x][node.y] = newV;
                        }
                    }
                }
            }

            arr = temp;

            if(!isCon){
                break;
            }
            answer++;
        }

        System.out.print(answer);

    }

    public static void bfs(int x, int y){
        Queue<Node> qq = new LinkedList<>();
        qq.add(new Node(x,y));

        check[x][y]= true;
        while(!qq.isEmpty()){
            Node cnt = qq.poll();
            q.add(new Node(cnt.x,cnt.y));
            teamnum++;
            teamnum_sum += arr[cnt.x][cnt.y];

            for(int i=0; i<4; i++){
                int nextX = cnt.x+moveX[i];
                int nextY = cnt.y + moveY[i];
                if(nextX >=0 && nextX < n && nextY >=0 && nextY < n && !check[nextX][nextY]){
                    if(Math.abs(arr[nextX][nextY] - arr[cnt.x][cnt.y]) >= small && Math.abs(arr[nextX][nextY] - arr[cnt.x][cnt.y]) <= big ){
                        check[nextX][nextY] = true;
                        qq.add(new Node(nextX,nextY));
                    }
                }
            }
        }

    }
}
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}