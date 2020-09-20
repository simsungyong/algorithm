package back2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem2533 {
    static int n;
    static boolean check[];
    static int value[][];
    static ArrayList<Integer>arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        value = new int[n+1][2];
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(value[1][0], value[1][1]));

    }

    public static void dfs(int temp){
        check[temp] = true;
        value[temp][0]=0;
        value[temp][1] = 1;

        for(int i=0; i<arr[temp].size(); i++){
            int next = arr[temp].get(i);
            if(!check[next]){
                dfs(next);
                value[temp][0] += value[next][1];
                value[temp][1] += Math.min(value[next][0],value[next][1]);
            }

        }
    }
}
