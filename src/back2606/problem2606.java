package back2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2606 {
    static ArrayList<Integer> list[];
    static int n, line;
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        check = new boolean[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(check[i]){
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int tmp = q.poll();
            check[tmp] = true;
            for(int i=0; i<list[tmp].size(); i++){
                if(!check[list[tmp].get(i)]){
                    q.add(list[tmp].get(i));
                }
            }
        }
    }
}
