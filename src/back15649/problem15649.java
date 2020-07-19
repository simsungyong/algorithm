package back15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem15649 {
    static int N, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        boolean check [] = new boolean[N+1];
        ArrayList<Integer> arr = new ArrayList<>();

        backtrack(0,check,arr);
    }

    public static void backtrack(int n, boolean check[], ArrayList arr){
        if(num ==n ){
            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!check[i]){
                check[i]= true;
                arr.add(i);
                backtrack(n+1, check, arr);
                arr.remove(arr.size()-1);
                check[i] = false;
            }
        }
    }
}
