package back2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2573 {
    static int arr[][];
    static boolean check[][];
    static int n,m;
    static int arrminus[][];
    static int moveX[]={1,-1,0,0};
    static int moveY[]={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        arrminus= new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
       int num=0;
       while (true) {
            int count=0;
            check = new boolean[n][m];
            arrminus = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][k] != 0 && check[i][k] == false) {
                        checking(i, k);
                        count++;
                    }
                    arr[i][k] = (arr[i][k] - arrminus[i][k]) < 0 ? 0: arr[i][k] - arrminus[i][k];


                }
            }
            if(count == 0) {
                System.out.println(0);
                break;
            } else if(count >= 2) {
                System.out.println(num);
                break;
            }

            num++;

        }
    }
    public static void checking(int x, int y){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nextx=x+moveX[i];
            int nexty=y+moveY[i];
            if(nextx>=0 && nextx <n && nexty >=0 && nexty < m){

                if(arr[nextx][nexty]==0){
                    arrminus[x][y] +=1;
                }

                if(!check[nextx][nexty] && arr[nextx][nexty]!=0){
                    checking(nextx,nexty);
                }
            }
        }
    }


}
