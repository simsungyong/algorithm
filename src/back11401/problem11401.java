package back11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = fibonacci(n,k);
        System.out.println(answer);
    }
    public static int fibonacci(int n, int k){
        if(k==0 || n==k){
            return 1;
        }
        return fibonacci(n-1,k-1)%1000000007+fibonacci(n-1,k)%1000000007;

    }
}
//시간초과