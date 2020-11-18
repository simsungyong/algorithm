package back17831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem17831 {
    static Node dp[];
    static ArrayList<Integer> arr[];
    static int cost[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        dp = new Node[n+1];
        cost = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            dp[i] = new Node(0,0);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++){
            int h = Integer.parseInt(st.nextToken());
            arr[h].add(i+1);
            arr[i+1].add(h);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int h = Integer.parseInt(st.nextToken());
            cost[i] = h;
        }

        long answer = dfs(0,1);


        System.out.println(answer);
    }

    public static long dfs(int prev, int cnt){

        if(cnt!=1 && arr[cnt].size()==1){
            return 0;
        }

        long max=Integer.MIN_VALUE;
        for(int i=0; i<arr[cnt].size(); i++){
            int next = arr[cnt].get(i);
            if(prev==next) continue;
            dp[cnt].f += dfs(cnt,next);
            long temp = cost[cnt]*cost[next]+dp[next].f-Math.max(dp[next].t,dp[next].f);
            max = Math.max(max,temp);
        }

        dp[cnt].t = dp[cnt].f+max;


        return Math.max(dp[cnt].t, dp[cnt].f);


    }
}
class Node{
    long t;
    long f;
    Node(long t,long f){
        this.t=t;
        this.f=f;
    }
}
