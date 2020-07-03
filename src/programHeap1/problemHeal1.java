package programHeap1;

import java.util.PriorityQueue;

public class problemHeal1 {
    public static void main(String[] args) {
        int [] arr= {1, 2, 3};
        int K = 1;
        System.out.println(solution(arr,K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i:scoville){
            q.add(i);
        }
        while(q.peek()<K){
            answer++;
            if(q.size()<=1){
                return -1;
            }
            int small = q.poll();
            int small2 = q.poll();

            int newone = small + small2*2;

            q.add(newone);
        }
        return answer;
    }
}

