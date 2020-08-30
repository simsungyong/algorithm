package back4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4963 {
    static int m,n;
    static boolean check[][];
    static int arr[][];
    static int moveX[]={-1,0,1};
    static int moveY[] = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0 && n==0){
                break;
            }
            check = new boolean[n][m];
            arr = new int[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++){
                for(int k=0; k<m; k++){
                    if(arr[i][k]==1 && !check[i][k]){
                        check[i][k] = true;
                        dfs(i,k);
                        answer++;
                    }
                }
            }

            sb.append(answer+"\n");

        }
        System.out.print(sb.toString());


    }
    public static void dfs(int x, int y){
        for(int i=0; i<3; i++){
            for(int k=0; k<3; k++){
                int xx = x+moveX[i];
                int yy = y+moveY[k];
                if(xx >=0 && yy>=0 && xx<n && yy<m && !check[xx][yy] && arr[xx][yy]==1){
                    check[xx][yy] = true;
                    dfs(xx,yy);
                }
            }
        }
    }
}
