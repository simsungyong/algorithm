package back1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1992 {
    static int arr[][];
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n=Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int k=0; k<n; k++){
                int num = line.charAt(k)-'0';
                arr[i][k] = num;
            }
        }

        divide(0,0,n);
        System.out.println(sb.toString());
    }

    public static void divide(int x, int y, int size){

        if(size==1){
            sb.append(arr[x][y]);
            return;
        }
        int isOne = arr[x][y];
        boolean isDivide = false;
        out : for(int i=x; i<x+size; i++){
            for(int k=y; k<y+size; k++){
                if(isOne != arr[i][k]){
                    isDivide = true;
                    break out;
                }
            }
        }

        if(!isDivide){
            sb.append(isOne);
            return;
        }else{
            sb.append("(");
            size = size/2;
            divide(x,y,size);
            divide(x,y+size, size);
            divide(x+size, y, size);
            divide(x+size, y+size, size);
            sb.append(")");
        }

    }
}
//분할정복~