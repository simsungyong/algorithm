package back1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr [] =new long[n+1];
        arr[1] =1;
        arr[2] =2;
        for(int i=3; i<=n; i++){
            arr[i] = (arr[i-2]+arr[i-1])%15746;
        }

        System.out.println(arr[n]);
    }
}
