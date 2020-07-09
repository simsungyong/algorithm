package back2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int list[] = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int left = 1;
        int right = list[n-1];

        while(left <= right){
            int cnt=1;
            int current=list[0];
            int mid = (left+right)/2;

            for(int now : list){
                if(now-current >= mid){
                    cnt++;
                    current = now;
                }
            }

            if(cnt>=k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(right);
    }
}
