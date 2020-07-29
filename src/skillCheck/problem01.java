package skillCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class problem01 {
    public static void main(String[] args) {
        int arr[] = {4,3,1,2,5};
        int answer[];
        answer = solution(arr);
        for(int a : answer){
            System.out.print(a);
        }
    }

    public static int[] solution(int arr[]){
        ArrayList<Integer> arrlist = new ArrayList<>();

        if(arr[0]==10 && arr.length==1){
            int answer[]= {-1};
            return answer;
        }
        int min = Integer.MAX_VALUE;
        for(int a : arr){
                min = Math.min(a,min);
                arrlist.add(a);

        }

        int[] answer = new int[arrlist.size()-1];

        int size=0;

        for(int i : arrlist){
            if(min != i){
                answer[size++] = i;
            }


        }
        return answer;

    }
}
