package back1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1072 {
    static long n ,m;
    static long percent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        percent = (m*100)/n;
        if(percent == 99 || percent ==100){
            System.out.print(-1);
        }
        else{
            System.out.print(search(0,n));
        }
    }

    public static long search(long left, long right){
        while(left <= right){
            long mid = (left+right)/2;
            long temp_per = ((mid+m)*100)/(n+mid);
            if((temp_per-percent)>=1){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
