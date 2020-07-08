package mnsoft05;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class mnsoft05 {
    static int answer = Integer.MIN_VALUE;
    //    static boolean check [][];
    static int visit[][];
    static int value[][];
    static int tempanswer=Integer.MIN_VALUE;
    static int dfsX[] = {0,1,0,-1};
    static int dfsY[] = {1,0,-1,0};

    public static void main(String[] args) {
        String board[][] = {{"A", "B", "T", "T", "T"}, {"T", "C", "D", "E", "T"}, {"T", "T", "T", "F", "T"}, {"B", "A", "H", "G", "F"}, {"C", "D", "E", "F", "G"}};
        solution(board);
    }

    public static void solution(String[][] board) {
        visit = new int[5][5];
        value = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                intialize();
                value[i][k]=1;
                bfs(i, k, board);
                find();
                System.out.println();
                answer = Math.max(answer, tempanswer);



            }
        }
        System.out.println(answer);
    }

    public static void intialize(){
        for(int i=0; i<5; i++){
            for(int k=0; k<5; k++){
                visit[i][k] = Integer.MAX_VALUE;
                value[i][k] = Integer.MIN_VALUE;
            }
        }
    }
    public static void find(){
        for(int i=0; i<5; i++){
            for(int k=0; k<5; k++){
                System.out.print(value[i][k]+" ");
                tempanswer = Math.max(tempanswer,value[i][k]);
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y, String[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1,0));
        visit[x][y] = 0;

        while(!q.isEmpty()){
            Node tmp = q.poll();


        for (int i = 0; i < 4; i++) {

            int next_x = x + dfsX[i];
            int next_y = y + dfsY[i];
            if (next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5) {
                continue;
            }
            if(visit[next_x][next_y] <=tmp.check){
                continue;
            }


            if ((board[next_x][next_y].charAt(0) - 'A' > board[x][y].charAt(0) - 'A') ) {
                if (value[next_x][next_y] < value[x][y] + 1) {

                    value[next_x][next_y] = value[x][y] + 1;
                    visit[next_x][next_y] = tmp.check;
                    q.add(new Node(next_x,next_y,tmp.dist+1,tmp.check));

                }


            } else {
                if (board[next_x][next_y].charAt(0) - 'A' < board[x][y].charAt(0) - 'A' ) {
                    if(tmp.check==0){
                        if (value[next_x][next_y] < value[x][y] + 1) {
                            value[next_x][next_y] = value[x][y] + 1;
                            visit[next_x][next_y] = tmp.check+1;
                            q.add(new Node(next_x,next_y,tmp.dist+1,tmp.check+1));

                        }
                    }

                }


            }
        }}

    }
}

class Node{
    int x,y,check,dist;
    Node(int x, int y, int dist, int check){
        this.x=x;
        this.y=y;
        this.dist = dist;
        this.check = check;
    }
}