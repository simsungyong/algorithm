package back6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int list[] = new int[n];
        int left=0;
        int right=0;
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(br.readLine());
            right +=cnt;

            left = left < cnt ? cnt :left;
            list[i] = cnt;
        }

        int mid=0;
        while(left <= right){
            int sum=0;
            int withdraw=1;
            mid = (left+right)/2;

            for(int i=0; i<n; i++){
                if(sum+list[i] > mid){

                    withdraw++;
                    sum=0;
                }

                sum+=list[i];
            }

            if(withdraw <= num){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left);
    }
}
