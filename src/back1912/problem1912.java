package back1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int list[] =new int[n+1];
        int dp[] = new int[n+1];
        int max=Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i] = Math.max(dp[i-1]+list[i], list[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
