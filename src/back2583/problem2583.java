package back2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem2583 {
    static int input[][];
    static int resultNum = 0;
    static int size=0;
    static ArrayList<Integer> sizearr = new ArrayList<>();
    static int x, y, k;
    static boolean check[][];
    static int dfsX[] = {0, 1, -1, 0};
    static int dfsY[] = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        input = new int[y + 1][x + 1];


        check = new boolean[y+1][x+1];
        for(int i =0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());
            for(int l = firstX+1; l<secondX+1; l++){
                for(int m = y-secondY+1; m <= y-firstY; m++){
                    input[m][l] = 1;
                }
            }

        }

        for(int i=1; i<=y; i++){
            for(int m = 1; m<=x; m++) {
                if (input[i][m] != 1 && check[i][m] == false) {
                    resultNum++;
                    size=0;
                    dfs(i, m);
                    sizearr.add(size);
                }
            }
        }
        Collections.sort(sizearr);


        System.out.println(resultNum);
        for(int i=0; i<sizearr.size(); i++){
            System.out.print(sizearr.get(i)+" ");
        }





    }

    public static void dfs(int a, int b){

        int tempx,tempy;
        check[a][b] = true;
        size++;
        for(int l=0; l<4; l++){
            tempy = a+dfsX[l];
            tempx = b+dfsY[l];
            if(tempx!=0 && tempy!=0 && tempy!=y+1 && tempx!=x+1){
                if(check[tempy][tempx] == false && input[tempy][tempx]!=1){
                    dfs(tempy,tempx);
                }
            }

        }

    }

}