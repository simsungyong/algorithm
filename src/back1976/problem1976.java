package back1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1976 {
    static int n, plan;
    static boolean check[];
    static ArrayList<Integer> arr[];
    static int plan_arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        plan = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        plan_arr = new int[plan];
        arr = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=1; k<=n; k++){
                int v = Integer.parseInt(st.nextToken());
                if( v==1){
                    arr[i].add(k);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<plan; i++){
            plan_arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(plan_arr[0]);
        boolean answer = true;

        for(int i=0; i<plan; i++){
            if(!check[plan_arr[i]]){
                answer = false;
                break;
            }
        }

        if(answer){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<arr[tmp].size(); i++){
                if(!check[arr[tmp].get(i)]){
                    check[arr[tmp].get(i)] = true;
                    q.add(arr[tmp].get(i));
                }
            }
        }
    }
}
