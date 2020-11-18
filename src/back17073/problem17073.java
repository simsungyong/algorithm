package back17073;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem17073 {
    static ArrayList<Integer> arr[];
    static double num=0;
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        arr = new ArrayList[n+1];
        check = new boolean[n+1];
        for(int i=1; i<=n; i++) arr[i] = new ArrayList<>();


        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(0,1);

        System.out.println(w/num);

    }

    public static void dfs(int prev, int cnt){
        if(arr[cnt].size()==1 && cnt!=1){
            num++;
            return;
        }


        for(int i=0; i<arr[cnt].size(); i++){
            int next = arr[cnt].get(i);
            if(next==prev) continue;

            dfs(cnt, next);
        }
    }
}
