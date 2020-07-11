package back1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1520 {
    static int arr[][];
    static int dp[][];
    static int moveX[]={0,0,1,-1};
    static int moveY[]={1,-1,0,0};
    static int num=0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                dp[i][k] = -1;
            }
        }
        int answer = dfs(0,0);

        System.out.println(answer);


    }
    public static int dfs(int x, int y){

        if(x==n-1 && y==m-1){
            return 1;
        }

        if(dp[x][y] == -1){
            dp[x][y]=0;
            for(int i=0; i<4; i++){
                int next_x = x+moveX[i];
                int next_y = y+moveY[i];
                if(next_x>=0 && next_x <n && next_y>=0 && next_y<m){
                    if(arr[x][y] > arr[next_x][next_y]){
                        dp[x][y] += dfs(next_x,next_y);
                    }

                }
            }
        }else{
            return dp[x][y];
        }

        return dp[x][y];
    }


}
//dfs시간초과난다.

//dfs+dp 메모이제이션 문제**중요  다시 계산할필요없이 들렷던 곳에 저장되있던 값을 들고온다.