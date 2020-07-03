package back1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class problem1012 {

    static int M,N,k;
    static int arr[][];
    static boolean check[][];
    static int answer=0;
    static int moveX[] = {0,0,1,-1};
    static int moveY[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int [N][M];
            check = new boolean[N][M];

            for(int a=0; a<k; a++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for(int a=0; a<N; a++){
                for(int b=0; b<M; b++){
                    if(!check[a][b] && arr[a][b]==1){
                        count(a,b);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            answer=0;



        }
    }

    public static void count(int a, int b){

            check[a][b] = true;
            for(int i=0; i<4; i++){
                int newX = a+moveX[i];
                int newY = b+moveY[i];
                if(newX>=0 && newX<N && newY>=0 && newY<M){
                    if(!check[newX][newY] && arr[newX][newY]==1){
                        count(newX,newY);
                    }
                }

            }

    }
}
//dfs하면 시간초과 안뜨고 bfs로 하면 시간초과뜸.
