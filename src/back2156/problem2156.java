package back2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int list[] = new int[n+1];
        int dp[] = new int[n+1];
        int max=0;
        for(int i=1; i<=n;i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = list[1];


        if(n==1){
            max = dp[1];
        }
        else{
            dp[2] = list[2]+list[1];

            if(n==2){
                max = dp[2];
            }
            else{
                for(int i=3; i<=n; i++){
                    dp[i] = Math.max(dp[i-2]+list[i], dp[i-3]+list[i-1]+list[i]);
                    dp[i] = Math.max(dp[i-1], dp[i]);
                    max = Math.max(dp[i],max);
                }
            }

        }



        System.out.println(max);
    }
}
