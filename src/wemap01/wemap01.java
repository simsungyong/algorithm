package wemap01;

public class wemap01 {
    public static void main(String[] args) {
        int N=4;
        int M =4;
        int [][] map = {{1,2,3,4},{0,3,3,2},{2,6,0,1},{2,4,3,1}};
        System.out.print(solution(N,M,map));

    }

    public static int solution(int N, int M, int [][]map){
        int answer;
        int dp [][] = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int k=1; k<=M; k++) {
                dp[i][k] = Math.max(dp[i-1][k], dp[i][k-1])+map[i-1][k-1];
            }


        }
        answer = dp[N][M];

        return answer;
    }
}
