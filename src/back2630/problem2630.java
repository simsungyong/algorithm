package back2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2630 {
    static int arr[][];
    static int countWhite=0;
    static int countBlue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        solution(n,0,0);
        System.out.println(countWhite);
        System.out.print(countBlue);


    }
    public static void solution(int size,int x, int y){
        if(size==1){
            if(arr[x][y]==1){
                countBlue++;
            }else{
                countWhite++;
            }
            return;
        }
        boolean same=true;

        int color = arr[x][y];
        out : for(int i=x; i<x+size; i++){
            for(int k=y; k<y+size; k++){
                if(color != arr[i][k]){
                    same = false;
                    break out;
                }
            }
        }

        if(same) {
            if(arr[x][y]==1){
            countBlue++;
            }else{
            countWhite++;
            }

            return;
        }
        size = size/2;
            solution(size, x,y);
            solution(size, x+size,y);
            solution(size, x, y+size);
            solution(size, x+size, y+size);
        }

    }
//왜 틀렷지..?
