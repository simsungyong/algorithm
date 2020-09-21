package back2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
        long arr[] = new long[n+1];
        long arrsum[] = new long[n+1];
        for(int i=1; i<=n; i++){
            long temp = Long.parseLong(br.readLine());
            arr[i] = temp;
            arrsum[i] = arrsum[i-1]+temp;
        }

        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type==1){
                int a = Integer.parseInt(st.nextToken());
                long b = Long.parseLong(st.nextToken());


            }
        }


    }
}
