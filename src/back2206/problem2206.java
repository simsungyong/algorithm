package back2206;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;
public class problem2206 {
    static int n,m;
    static int input[][];
    static int value[][][];
    static int mx []= {0,1,-1,0};
    static int my [] = {-1,0,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n][m];
        value = new int[n][m][2];

        for(int i=0 ; i<n; i++){
            String s = br.readLine();
            for(int k=0 ; k<m; k++){
                value[i][k][0] = Integer.MAX_VALUE;
                value[i][k][1] = Integer.MAX_VALUE;
                input[i][k] = s.charAt(k)-'0';
            }
        }
        bfs();

        int answer = Math.min(value[n-1][m-1][0], value[n-1][m-1][1]);
        if(answer< Integer.MAX_VALUE){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }



    }

    public static void bfs(){
        Queue<Node> q= new LinkedList<>();
        value[0][0][0] = 1;
        q.add(new Node(0,0,false));
        while(!q.isEmpty()){
            Node temp = q.poll();
            for(int i=0; i<4; i++){
                int nextx = temp.x+mx[i];
                int nexty = temp.y+my[i];
                if(nextx>=0 && nextx<n && nexty>=0 && nexty<m){
                    if(temp.check){
                        if(input[nextx][nexty]==0 && value[temp.x][temp.y][1]+1 < value[nextx][nexty][1]){
                            value[nextx][nexty][1] = value[temp.x][temp.y][1]+1;
                            q.add(new Node(nextx,nexty, true));
                        }
                    }else{
                        if(input[nextx][nexty]==0){
                            if(value[temp.x][temp.y][0]+1 < value[nextx][nexty][0]){
                            value[nextx][nexty][0] = value[temp.x][temp.y][0]+1;
                            q.add(new Node(nextx,nexty, false));
                            }
                        }else{
                            if(value[temp.x][temp.y][0]+1 < value[nextx][nexty][1]){
                                value[nextx][nexty][1] = value[temp.x][temp.y][0]+1;
                                q.add(new Node(nextx,nexty, true));
                            }
                        }
                    }
                }
            }
        }

    }
}

class Node {
    int x,y;
    boolean check;
    Node(int x, int y, boolean check){
        this.x=x;
        this.y=y;
        this.check= check;
    }
}
