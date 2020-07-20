package back9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class problem9663 {
    static int n;
    static boolean check[][];
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n][n];
        backtrack(0,-1,0);
        System.out.println(answer);
    }

    public static void backtrack(int num,int x, int y){
        if(num==n){

            answer++;
            return;
        }

        if(x+1 >= n) {
            return;
        }
        for(int i=0; i<n; i++){
            if(!check[x+1][i]){
                    if(checkingX(x+1,i) && leftup(x+1,i) && rightup(x+1,i)){
                        check[x+1][i] = true;
                        backtrack(num+1, x+1,i);
                        check[x+1][i] = false;
                    }
                }
            }
        }



    public static boolean checkingX(int x ,int y){

        boolean isPossible=true;
        int diff=1;


        while(true){

            if(x-diff < 0){
                diff=1;
                break;
            }
            if(check[x-diff][y]){
                isPossible = false;
                break;
            }
            diff++;
        }

    return isPossible;
    }

    public static boolean leftup(int x, int y){
        boolean isPossible=true;
        int diff=1;


        while(true){

            if(x-diff < 0 || y-diff<0){
                break;
            }
            if(check[x-diff][y-diff]){
                isPossible = false;
                break;
            }
            diff++;
        }

        return isPossible;
    }

    public static boolean rightup(int x, int y){
        boolean isPossible=true;
        int diff=1;


        while(true){

            if(x-diff < 0 || y+diff>=n){
                break;
            }
            if(check[x-diff][y+diff]){
                isPossible = false;
                break;
            }
            diff++;
        }

        return isPossible;
    }


}
