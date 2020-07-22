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
    static int value[][];
    static boolean wall [][][];
    static int dfsX []= {0,1,-1,0};
    static int dfsY [] = {-1,0,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n][m];
        value = new int[n][m];
        wall = new boolean[n][m][2];

        for(int i=0 ; i<n; i++){
            String s = br.readLine();
            for(int k=0 ; k<m; k++){
                value[i][k] = Integer.MAX_VALUE;
                input[i][k] = s.charAt(k)-'0';
            }
        }
        value[0][0] = 0 ;

        bfs();



        if(value[n-1][m-1] < Integer.MAX_VALUE){
            System.out.println(value[n-1][m-1]+1);
        }else{
            System.out.println(-1);
        }

    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,false));
        wall[0][0][0] = true;
        wall[0][0][1] = true;
         while(!q.isEmpty()){

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
