package ntechService;

import java.util.Stack;

public class problem1 {
    public static void main(String[] args) {
        int []arr = {6, 5, 7, 3, 4, 2};
        System.out.println(solution(arr));
    }


    public static int solution(int[] histogram) {
        int answer=0;
        for(int i=2; i<histogram.length; i++){
            for(int k=0; k<i-2; k++){
                if(histogram[k] >= histogram[i]){
                    answer = Math.max(answer, histogram[i]*(i-k-1));
                    break;
                }else{
                    answer = Math.max(answer, histogram[k]*(i-k-1));
                    if(histogram[k]*(i-k-1) >= histogram[i]){
                        break;
                    }
                }
            }
        }


        return answer;
    }
}
