package back1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem1759 {
    static int n, total;
    static boolean check[];
    static String arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        check = new boolean[total];
        backtracking(0, 0);


    }

    public static void backtracking(int start, int depth) {
        if (depth == n) {
            checkPW(start);
        }
        for (int i = start; i < total; i++) {
            check[i] = true;
            backtracking(i + 1, depth + 1);
            check[i] = false;
        }
    }
    public static void checkPW(int n){
        int a=0;
        int b=0;
        String ans="";
        for(int i=0; i<n; i++){
            if(check[i]){
                if(arr[i].equals("a") || arr[i].equals("e")|| arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
                    a++;
                }else{
                    b++;
                }
                ans+=arr[i];
            }

        }
        if(a>=1 && b>=2){
            System.out.println(ans);
        }
    }
}
