package Samsung.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class problem테트로미노 {
    static int input[][];
    static int temp[] = new int[4];
    static boolean check[][];
    static int answer = Integer.MIN_VALUE;
    static int movex[]={0,0,1,-1};
    static int n,m;
    static int movey []={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n][m];
        check = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++){
                input[i][k] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<n; i++){
            for(int k=0; k<m; k++){
                check[i][k] = true;
                dfs(i,k,1, input[i][k]);
                check[i][k] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int num, int value){
        if(num==4){
            answer = Math.max(value, answer);
            check[x][y]=false;
            return;
        }


        for(int i=0; i<4; i++){
            int newx = x+movex[i];
            int newy = y+ movey[i];
            if(newx>=0 && newx<n && newy>=0 && newy<m){
                if(!check[newx][newy]){
                    check[newx][newy] = true;
                    dfs(newx,newy,num+1,value+input[newx][newy]);
                    check[newx][newy] = false;

                    if(num==2){
                        temp[i] = input[newx][newy];
                    }
                }


            }
        }
        if(num==2){
            Arrays.sort(temp);
            if(temp[3] != 0 && temp[2]!=0){
                answer = Math.max(answer, value+temp[3]+temp[2]);
            }

            Arrays.fill(temp,0);
        }





    }
}
