package programPrior4;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prior4 {
    public static void main(String[] args) {
        String [] arr = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        for(int i : solution(arr)){
            System.out.println(i);
        }

    }
    public static int[] solution(String[] operations) {
        int[] answer={0,0};
        PriorityQueue<Integer> qMax = new PriorityQueue<>();//ㅇ오름차순
        PriorityQueue<Integer> qMin = new PriorityQueue<>(Comparator.reverseOrder());

        for(String temp : operations){
            StringTokenizer st = new StringTokenizer(temp);
            String cntStep = st.nextToken();
            if(cntStep.equals("I")){
                int cnt = Integer.parseInt(st.nextToken());
                qMax.add(cnt);
                qMin.add(cnt);
            }else{
                if(!qMax.isEmpty()){
                    int cntValue = Integer.parseInt(st.nextToken());
                    if(cntValue == -1){
                        int peek = qMax.peek();
                        qMax.remove(peek);
                        qMin.remove(peek);
                    }else{
                        int peek = qMin.peek();
                        qMax.remove(peek);
                        qMin.remove(peek);
                    }
                }

            }
        }

        if(!qMax.isEmpty()){
           answer[0] = qMin.peek();
           answer[1] = qMax.peek();
        }

        return answer;
    }
}


