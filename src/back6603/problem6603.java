package back6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//백트래킹

public class problem6603 {
        static boolean check[];
        static int arr[];
        static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String temp[] =br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            if(N==0){
                break;
            }
            arr = new int[N];
            check = new boolean[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(temp[i+1]);
            }
            backtracking(0,0);

            System.out.println();

        }

    }

    public static void backtracking(int start, int num){
        if(num == 6){
            for(int i=0; i<start; i++){
                if(check[i] == true){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        for(int i=start; i<N; i++){
            check[i] = true;
            backtracking(i+1, num+1);
            check[i] = false;
        }
    }
}

