package Samsung.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem17144 {

    static int n,m;
    static int target_time;
    static int clean[];
    static int temp[][];
    static int movex[]={0,0,1,-1};
    static int movey[]={1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        clean = new int[2];
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target_time = Integer.parseInt(st.nextToken());
        int input[][] = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++){
                int v = Integer.parseInt(st.nextToken());
                input[i][k] = v;
                if(i>=1 && v==-1 && input[i-1][0]==-1){
                    clean[0] = i-1;
                    clean[1] = i;
                }
            }
        }
        int cnt = 0;
        while(cnt < target_time){
            input = spreadDirt(input);
            input = cleandirt(input);
            cnt++;
        }
        int answer = 0;
        for(int i=0; i<n; i++) {
            for (int k = 0; k < m; k++) {
                if (input[i][k]!=-1){
                    answer+=input[i][k];
                }
            }
        }
        System.out.println(answer);


    }

    public static int[][] spreadDirt(int input[][]){
        temp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int k=0; k<m; k++){
                if(input[i][k]==-1){
                    temp[i][k] = -1;
                    continue;
                }

                if(input[i][k]!=-1 && input[i][k]!=0){
                    temp[i][k] += input[i][k];
                    int divided = input[i][k]/5;
                    for(int l=0; l<4; l++){
                        int newx = i+movex[l];
                        int newy = k+movey[l];
                        if(newx >=0 && newx<n && newy>=0 && newy < m && input[newx][newy]!=-1){
                            temp[newx][newy] += divided;
                            temp[i][k] -= divided;
                        }
                    }
                }
            }
        }
        return temp;
    }
    public static int[][] cleandirt(int input[][]){
        int tempup=0;
        int tempdown=0;
        int up,down;
        for(int i=1; i<m; i++){
            up = input[clean[0]][i];
            down = input[clean[1]][i];
            input[clean[0]][i] = tempup;
            input[clean[1]][i] = tempdown;
            tempup = up;
            tempdown = down;
        }

        for(int i=clean[0]-1; i>=0; i--){
            up = input[i][m-1];
            input[i][m-1] = tempup;
            tempup = up;
        }

        for(int i=clean[1]+1; i<n; i++){
            down = input[i][m-1];
            input[i][m-1] = tempdown;
            tempdown = down;
        }
        for(int i=m-2; i>=0; i--){
            up = input[0][i];
            down = input[n-1][i];
            input[0][i] = tempup;
            input[n-1][i] = tempdown;
            tempup = up;
            tempdown = down;
        }

        for(int i=1; i<clean[0]; i++){
            up = input[i][0];
            input[i][0] = tempup;
            tempup = up;
        }

        for(int i=n-2; i>clean[1]; i--){
            down = input[i][0];
            input[i][0] = tempdown;
            tempdown = down;
        }



        return input;
    }

}
