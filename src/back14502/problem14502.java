package back14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem14502 {
    static int x,y;
    static int input[][];
    static int copy[][];
    static int safeArea=0;
    static int dfsX[] = {0, 1, -1, 0};
    static int dfsY[] = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        input = new int[x][y];
        copy = new int[x][y];

        for(int i=0; i<x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < y; k++) {
                input[i][k] = Integer.parseInt(st.nextToken());
            }
        }


        setWall(0,0);

        System.out.println(safeArea);


    }

    public static void setWall(int first, int num){
        for(int i=0; i<x; i++) {
            for (int k = 0; k < y; k++) {
                copy[i][k] = input[i][k];
            }
        }

        int tempx;
        int tempy;

        if(num==3){
            for(int i =0; i<x;i++){
                for(int k=0; k<y; k++){
                    if(copy[i][k]==2){
                        spreadVirus(i,k);
                    }
                }
            }


            safeArea = Math.max(safeArea, getSafe());
            return;

        }

        for(int i = first; i< x*y; i++){
            tempx = (i/y);
            tempy = (i%y);
            if(input[tempx][tempy]==0 && tempx < x){
                input[tempx][tempy]=1;
                setWall(first+1, num+1);
                input[tempx][tempy]=0;
            }
        }

    }

    public static void spreadVirus(int a, int b){
        int tempx,tempy;
        for(int l=0; l<4; l++){
            tempx = a+dfsX[l];
            tempy = b+dfsY[l];
            if((tempx >=0 && tempx<x) && (tempy>=0 && tempy<y)) {
                if (copy[tempx][tempy] == 0) {
                    copy[tempx][tempy] = 2;
                    spreadVirus(tempx, tempy);
                }
            }
        }
    }

    public static int getSafe(){
        int safe=0;
        for(int i =0; i<x;i++){
            for(int k=0; k<y; k++) {
                if (copy[i][k] == 0) {
                    safe++;
                }
            }
        }
        return safe;
    }
}
