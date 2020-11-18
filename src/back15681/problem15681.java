package back15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem15681 {
    static int dp[];
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int que = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        arr = new ArrayList[n+1];

        for(int i=1; i<=n; i++) arr[i] = new ArrayList<>();


        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dp(0,root);

        for(int i=0; i<que; i++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }

    public static int dp(int prev, int cnt){
        if(dp[cnt]!=0) return dp[cnt];

        dp[cnt]=1;
        for(int i=0; i<arr[cnt].size(); i++){
            int next = arr[cnt].get(i);
            if(next==prev) continue;

            dp[cnt]+=dp(cnt, next);
        }
        return dp[cnt];
    }
}
