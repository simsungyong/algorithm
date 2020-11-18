package back1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem1289 {
    static ArrayList<Node> list[];
    static boolean check[][];
    static boolean parents[];
    static int value=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        parents = new boolean[n+1];
        check = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,v));
            list[b].add(new Node(a,v));
        }

        for(int i=1; i<=n; i++){
            check[i][i] = true;
            dfs(i,1, i);
        }

        System.out.println(value%1000000007);



    }
    public static void dfs(int index, int v, int start){
        parents[index] = true;

        if(!check[index][start] || !check[start][index]){
            check[start][index]=true;
            check[index][start]  = true;
            value += v%1000000007;
        }

        for(int i=0; i<list[index].size(); i++){
            Node next = list[index].get(i);
            if( !parents[next.to] ){
                int cost = (v*next.v)%1000000007;
                dfs(next.to, cost, start);
            }
        }
        parents[index] = false;

    }
}
class Node {
    int to, v;
    Node(int to, int v){
        this.to = to;
        this.v = v;
    }
}
