package back7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem7562 {
    static int n;
    static int dp[][];
    static int goalX;
    static int goalY;
    static int answer;
    static int moveX[]={-1,-1,1,1,2,2,-2,-2};
    static int moveY[]={-2,2,-2,2,-1,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            n = Integer.parseInt(br.readLine());
            dp = new int[n][n];
            answer =  Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            bfs(startX,startY);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                dp[i][k] = Integer.MAX_VALUE;
            }
        }
        q.add(new Node(x,y));
        dp[x][y] = 0;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.x == goalX && tmp.y == goalY){
                answer= Math.min(answer, dp[tmp.x][tmp.y]);
                continue;
            }

            for(int i=0; i<8; i++){
                int nextX=tmp.x+moveX[i];
                int nextY=tmp.y+moveY[i];
                if(nextX>=0 && nextX < n && nextY >=0 && nextY <n){
                    if(dp[nextX][nextY] > dp[tmp.x][tmp.y]+1){
                        dp[nextX][nextY] = dp[tmp.x][tmp.y]+1;
                        q.add(new Node(nextX,nextY));
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
