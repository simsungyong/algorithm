package back2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2665 {
    static int n;
    static int input[][];
    static int v[][];
    static int moveX[]={0,0,-1,1};
    static int moveY[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        v = new int[n][n];
        for(int i=0; i<n;i++){
            String temp = br.readLine();
            for(int k=0; k<n; k++){
                input[i][k] = temp.charAt(k)-'0';
                v[i][k] = Integer.MAX_VALUE;
            }

        }
        v[0][0] = 0;
        dijk(0,0);

        System.out.println(v[n-1][n-1]);

    }

    public static void dijk(int x, int y){
        for(int i=0; i<4; i++){
            int xx = x+moveX[i];
            int yy = y+moveY[i];
            if(xx < 0 || yy <0 || xx>=n || yy >=n){
                continue;
            }

            if(input[xx][yy]==1){
                if(v[xx][yy] > v[x][y]){
                    v[xx][yy] = v[x][y];
                    dijk(xx,yy);
                }

            }else{
                if(v[xx][yy] > v[x][y]+1){
                    v[xx][yy] = v[x][y]+1;
                    dijk(xx,yy);
                }
            }

        }
    }
}
