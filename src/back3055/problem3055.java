package back3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem3055 {
    static int n,m;
    static int arr[][];
    static boolean check[][];
    static Queue<Node> q;
    static Queue<Node> wq;
    static int goalX,goalY;
    static int moveX[]={0,0,1,-1};
    static int moveY[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        q = new LinkedList<>();
        wq = new LinkedList<>();
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int k=0; k<m; k++){
                arr[i][k] = Integer.MAX_VALUE;
                int v = temp.charAt(k)-'*';
                if(v==26){
                    goalX = i;
                    goalY = k;

                }else if(v== 0){
                    wq.add(new Node(i,k));
                    check[i][k] = true;
                }else if(v==46){
                    check[i][k] = true;
                }else if(v ==41){
                    arr[i][k] = 0;
                    q.add(new Node(i,k));
                }

            }
        }
        bfs();
        if(arr[goalX][goalY]==Integer.MAX_VALUE){
            System.out.print("KAKTUS");
        }else{
            System.out.print(arr[goalX][goalY]);
        }





    }

    public static void bfs(){
        while(!q.isEmpty()){

            int wqsize = wq.size();
            int qsize = q.size();
            for(int i=0;i<wqsize; i++){
                Node temp = wq.poll();
                for(int k=0; k<4; k++){
                    int new_x = temp.x+moveX[k];
                    int new_y = temp.y+moveY[k];
                    if(new_x>=0 && new_x<n && new_y >=0 && new_y< m && !check[new_x][new_y] &&  !(new_x==goalX && new_y==goalY)){
                        check[new_x][new_y]=true;
                        wq.add(new Node(new_x,new_y));
                    }
                }
            }


            for(int i=0; i<qsize; i++){
                Node temp = q.poll();
                for(int k=0; k<4; k++){
                    int new_x = temp.x+moveX[k];
                    int new_y= temp.y+moveY[k];
                    if(new_x>=0 && new_x<n && new_y >=0 && new_y< m){
                        if(!check[new_x][new_y] && arr[new_x][new_y] > arr[temp.x][temp.y]+1){
                            arr[new_x][new_y] = arr[temp.x][temp.y]+1;
                            q.add(new Node(new_x,new_y));
                        }
                    }
                }
            }






        }
    }
}

class Node {
    int x,y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
