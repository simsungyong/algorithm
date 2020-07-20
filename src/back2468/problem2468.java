package back2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2468 {
    static int n;
    static boolean check[][];
    static int arr[][];
    static int moveX[] = {1,-1,0,0};
    static int moveY[] = {0,0,1,-1};
    static int answer = 0;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][k] = tmp;
                min = Math.min(tmp,min);
                max = Math.max(tmp,max);
            }
        }


        for(int i=min-1; i<max;i++){
            check = new boolean[n][n];
            int cnt_answer = 0;
            for(int x = 0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(arr[x][y] > i && !check[x][y]){
                        bfs(x,y, i);
                        cnt_answer++;
                    }
                }
            }

            answer = Math.max(answer,cnt_answer);

        }

        System.out.println(answer);


    }

    public static void bfs(int x, int y, int limit){
        q = new LinkedList<>();
        q.add(new Node(x,y));
        check[x][y] = true;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int newX = tmp.x+moveX[i];
                int newY = tmp.y+moveY[i];
                if(newX <0 || newX >=n || newY<0|| newY>=n){
                    continue;
                }
                if(!check[newX][newY] && arr[newX][newY]> limit ){
                    check[newX][newY] = true; //방문표시를 큐에서 뺄때하면 중복생김. 메모리초과
                    q.add(new Node(newX,newY));
                }


            }
        }
    }
}

class Node {
    int x;
    int y;
    Node(int x, int y){
        this.x =x;
        this.y=y;
    }
}
