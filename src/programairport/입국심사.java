package programairport;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n=6;
        int [] times = {7,10};
        System.out.println(solution(n,times));
    }
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Integer.MAX_VALUE;
        long max;
        long min=0;
        long mid;
        max = times[times.length-1] * n;
        while(min <= max){
            long done=0;
            mid = (min + max) /2;
            for(int temp : times){
                done += mid/temp;
            }

            if(done  < n){
                min = mid+1;
            }else{
                answer= Math.min(answer, mid);
                max = mid-1;
            }

        }



        return answer;
    }
}
