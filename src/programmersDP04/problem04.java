package programmersDP04;

public class problem04 {
    public static void main(String[] args) {
        int m=6;
        int n=7;
        int puddels[][] = {{2,2},{2,3},{4,1},{6,3},{5,2}};
        solution(m,n,puddels);

    }

    public static long solution(int m, int n, int puddles[][]){
        boolean check[][]=new boolean [n+1][m+1];
        long arr [][] = new long[n+1][m+1];
        arr[1][1] = 1;
        for(int i=0; i<puddles.length; i++){
            int y = puddles[i][0];
            int x = puddles[i][1];
            check[x][y] = true;
        }

        for(int i=1; i<=n; i++){
            for(int k=1; k<=m; k++){
                if(i==1 && k==1){
                    continue;
                }
                if(check[i][k]!=true){
                    arr[i][k] = (arr[i-1][k]+arr[i][k-1])%1000000007;
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int k=1; k<=m; k++) {
                System.out.print(arr[i][k]+" ");
            }
            System.out.println();
            }

        long answer = arr[n][m]%1000000007;

        return answer;
    }
}
