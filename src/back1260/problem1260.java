package back1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1260 {
    static int n, line, start;
    static ArrayList<Integer> list[];
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        check=new boolean[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
            Collections.sort(list[a]);
            Collections.sort(list[b]);
        }

        dfs(start);
        System.out.println();

        check=new boolean[n+1];

        bfs(start);



    }

    public static void dfs(int start){
        System.out.print(start+" ");
        check[start] = true;
        for(int i=0; i<list[start].size(); i++){
            if(check[list[start].get(i)]==false){
                dfs(list[start].get(i));
            }
        }

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int tmp = q.poll();
            if(check[tmp]==false){
                System.out.print(tmp+" ");
            }
            check[tmp] = true;

            for(int i=0; i<list[tmp].size(); i++){
                if(check[list[tmp].get(i)]==false){
                    q.add(list[tmp].get(i));
                }
            }
        }

    }
}
