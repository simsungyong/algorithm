package programHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class problem라면 {
    public static void main(String[] args) {

        int stock=4;
        int dates[]={4,10,15};
        int supplies [] = {20,5,10};
        int k =30;
        System.out.print(solution(stock,dates,supplies,k));

    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
        int cnt=0;

        for(int i=0; i<k; i++){
            if(cnt < dates.length){
                if(i == dates[cnt]){
                    q.add(supplies[cnt]);
                    cnt++;
                }

            }

            if(stock==0){
                stock = stock+ q.poll();
                answer++;
            }

            stock--;


        }

        return answer;
    }
}
