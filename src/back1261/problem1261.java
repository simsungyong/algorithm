package back1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1261 {
    static int M,N;
    static int arr[][];
    static int roadarr[][];
    static int moveX[]={0,1,-1,0};
    static int moveY[]={1,0,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M =Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        roadarr =new int [N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int k=0; k<M; k++){
               arr[i][k] = s.charAt(k)-'0';
               roadarr[i][k] = Integer.MAX_VALUE;
            }
        }
        dijkstra();
        System.out.println(roadarr[N-1][M-1]);




    }

    public static void dijkstra(){
        Queue<Node> q = new LinkedList<>();
        roadarr[0][0] = 0;
        q.add(new Node(0,0));

        while(!q.isEmpty()){
            Node tmp= q.remove();
            for(int i=0; i<4; i++){
                int x = tmp.x+moveX[i];
                int y = tmp.y+moveY[i];
                if(x >=0 && x<N && y<M && y >=0){
                    if(arr[x][y]==1){
                        if(roadarr[x][y] > roadarr[tmp.x][tmp.y] +1){
                            roadarr[x][y]  = roadarr[tmp.x][tmp.y] +1;
                            q.add(new Node(x,y));
                        }
                    }else{
                        if(roadarr[x][y] > roadarr[tmp.x][tmp.y]){
                            roadarr[x][y]  = roadarr[tmp.x][tmp.y];
                            q.add(new Node(x,y));
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int x,y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
