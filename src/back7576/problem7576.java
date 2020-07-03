package back7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem7576 {
    static int M,N;
    static int input[][];
    static Queue<Node> q = new LinkedList<>();

    static int moveX[] = {0, 1, -1, 0};
    static int moveY[] = {-1, 0, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        boolean count_zero=false;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<M; k++){
                input[i][k] = Integer.parseInt(st.nextToken());
                if(input[i][k]==0){
                    count_zero=true;
                }
            }
        }

        if(!count_zero){
            System.out.println(0);
            return;
        }

        for(int i=0; i<N; i++ ){
            for(int k=0; k<M; k++){
                if(input[i][k]==1){
                    q.add(new Node(i,k));
                }
            }
        }

        dpbfs();

        int time=0;



        for(int i=0; i<N; i++ ){
            for(int k=0; k<M; k++){
                if(input[i][k]==0){
                    System.out.println(-1);
                    return;
                }
                time = Math.max(time,input[i][k]);
            }

        }

        System.out.println(time-1);


    }

    public static void dpbfs(){

        while(!q.isEmpty()){
            Node tmp = q.poll();


            for (int i = 0; i < 4; i++) {
                int newX = tmp.x + moveX[i];
                int newY = tmp.y + moveY[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M ){
                    if(input[newX][newY]==0){
                            input[newX][newY] = input[tmp.x][tmp.y]+1;
                            q.add(new Node(newX,newY));

                    }
                }
            }
        }
    }
}

class Node {
    int x,y;
    Node(int x, int y){
        this.x =x;
        this.y=y;
    }
}


//어려움.
