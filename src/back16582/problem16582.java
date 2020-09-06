package back16582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem16582 {
    static int n,line,money;
    static int arr[];
    static boolean check[];
    static int answer=0;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        check = new boolean[n+1];
        list = new ArrayList[n+1];
        line = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=n; i++){
            if(!check[i]){
                bfs(i);
            }
        }

        if(answer <= money){
            System.out.println(answer);
        }else{
            System.out.println("Oh no");
        }
    }
    public static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        int cost = Integer.MAX_VALUE;
        check[index] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            cost = Math.min(cost, arr[tmp]);
            for(int i=0; i<list[tmp].size(); i++){
                if(!check[list[tmp].get(i)]){
                    check[list[tmp].get(i)] = true;
                    q.add(list[tmp].get(i));
                }
            }
        }
        answer += cost;
    }
}
