package back2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dp[]= new int[m+1];
        int coin[] = new int[n+1];
        for(int i=1; i<=n; i++){
            int co = Integer.parseInt(br.readLine());
            coin[i] = co;
        }

        dp[0]=1;
        for(int i=1; i<=n; i++){
            for(int k=1; k<=m; k++){
                if(k >= coin[i]){
                    dp[k] = dp[k]+ dp[k-coin[i]];
                }
            }
        }

        System.out.println(dp[m]);
    }
}
//어려움.