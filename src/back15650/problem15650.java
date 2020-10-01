package back15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem15650 {
    static int N, num;
    static int list[];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        list= new int [num];
        check = new boolean[N+1];
        backtrack(0,0);

    }
    public static void backtrack(int n, int cnt){
        if(num==n){
            for(int a : list){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }

        for(int i=cnt+1; i<=N; i++){
            if(!check[i]){
                check[i] = true;
                list[n] = i;
                backtrack(n+1,i);
                check[i] = false;
                list[n] = 0;
            }
        }
    }
}


