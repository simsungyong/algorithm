package programmers도둑질;

import java.util.Arrays;

public class problem도둑질 {
    public static void main(String[] args) {
        int money[]={1,2,3,1};
        solution(money);
    }
    public static int solution(int money[]){
        long max=0;

        long dp[] = new long [money.length+2];
        dp[2] = money[0];

        for (int i = 3; i < money.length+1; i++) {
            dp[i] = Math.max(dp[i-3], dp[i-2]) + money[i-2];
            }
        max= Math.max(dp[money.length-1], dp[money.length]);

        dp = new long [money.length+2];

        for (int i = 3; i < money.length+2; i++) {
            dp[i] = Math.max(dp[i-3], dp[i-2]) + money[i-2];
            System.out.println(dp[i]+" ");
        }

            max= Math.max(max, Math.max(dp[money.length], dp[money.length+1]));

        return (int)max;

        }

}
