package back3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3079 {
    static int n,m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        long min = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(br.readLine());
            min = Math.min(cnt, min);
            arr[i] = cnt;
        }

        long answer = search(0,min*m);

        System.out.print(answer);


    }

    public static long search(long left, long right){
        long sum;
        while(left <= right){
            sum=0;
            long mid = (left+right)/2;
            for(int i=0; i<n; i++){
                sum += mid/arr[i];
            }

            if(sum >= m){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
