package back1018;

import java.util.Scanner;

public class problem1018 {
    private static char exam [][];
    private static char board [][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int min = Integer.MAX_VALUE;
        exam = new char [2][8];
        exam[0] = "WBWBWBWB".toCharArray();
        exam[1] = "BWBWBWBW".toCharArray();

        board = new char[n][m];
        for(int i =0; i<n; i++){
            board[i] = sc.nextLine().toCharArray();
        }

        for(int i=0; i<n-7; i++){
            for(int k=0; k<m-7; k++){
                min = Math.min(min, calculate(i,k));
            }
        }

        System.out.println(min);



    }

    public static int calculate(int i, int k){
        int min_val = Integer.MAX_VALUE;
        for(int cur=0; cur<2; cur++){
            int cnt = 0;
            for(int a=i; a<i+8; a++){
                for(int b=k; b<k+8; b++){
                    if(board[a][b] != exam[(a+cur)%2][b-k]){
                        cnt++;
                    }
                }
            }
            min_val = Math.min(min_val, cnt);
        }


        return min_val;
    }
}
