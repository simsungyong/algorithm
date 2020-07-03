package back2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max,min;
        int input [][] = new int[n+1][5];
        int dp[][] = new int[n+1][5];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=1; k<4; k++){
                input[i][k] = Integer.parseInt(st.nextToken());

            }
        }



        //최대값
        for(int i=1; i<=n; i++){
            for(int k=1; k<4; k++){
                dp[i][k] = Math.max(Math.max(dp[i-1][k-1], dp[i-1][k]), dp[i-1][k+1]) + input[i][k];
            }
        }
        max = Math.max(Math.max(dp[n][1], dp[n][2]), dp[n][3]);
        //최소값
        for(int i=1; i<=n; i++) {
            for (int k = 1; k < 4; k++) {
                if (k == 1) {
                    dp[i][k] = Math.min(dp[i - 1][k], dp[i - 1][k + 1]) + input[i][k];
                } else if (k == 3) {
                    dp[i][k] = Math.min(dp[i - 1][k - 1], dp[i - 1][k]) + input[i][k];
                } else {
                    dp[i][k] = Math.min(Math.min(dp[i - 1][k - 1], dp[i - 1][k]), dp[i - 1][k + 1]) + input[i][k];

                }
            }
        }
        min = Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]);

        System.out.print(max+" "+min);
    }
}
