package back1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1780 {
    static int arr[][];
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new int[3];
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        for(int a : answer){
            System.out.println(a);
        }
    }
    public static void divide(int x, int y, int size ){
        int criteria  = arr[x][y];
        if(size==1){
            answer[criteria+1] += 1;
            return;
        }
        boolean isSame = true;
        out : for(int i=x; i<x+size; i++){
            for(int k=y; k<y+size; k++){
                if(criteria != arr[i][k]){
                    isSame = false;
                    break out;
                }
            }
        }

        if(isSame){
            answer[criteria+1] +=1;
            return;
        }

        size= size/3;
        for(int i=0; i<3; i++){
            for(int k=0; k<3; k++){
                divide(x+i*size,y+k*size,size);
            }
        }



    }
}
