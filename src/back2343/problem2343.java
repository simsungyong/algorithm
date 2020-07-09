package back2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int list[] = new int[l];
        int left=0;
        int right=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<l; i++){
            list[i] = Integer.parseInt(st.nextToken());
            right += list[i];
            left = left<list[i] ? list[i] : left; //이 줄이 없으면 에러가난다??? why?? 가장 작은 값이 시작점이 되야하긴하는데...
        }
        int mid=0;
        while(left<= right){
            mid = (left+right)/2;
            int sum=0;
            int cnt=0;
            for(int i=0; i<l; i++){
                if(sum+list[i] > mid){
                    sum=0;
                    cnt++;
                }
                sum += list[i];
            }

            if(sum!=0){
                cnt++;
            }

            if(cnt > num){
                left = mid+1;

            }else{
                right = mid-1;

            }

        }

        System.out.println(left);




    }
}
