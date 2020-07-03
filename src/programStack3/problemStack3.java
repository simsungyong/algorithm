package programStack3;

import java.util.LinkedList;
import java.util.Queue;

public class problemStack3 {
    public static void main(String[] args) {
        int progresses [] = {93,30,55};
        int speeds [] = {1,30,5};
        int arr[]=solution(progresses, speeds);
//        for(int temp : arr){
//            System.out.print(temp);
//        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int arrTime [] = new int [progresses.length];

        Queue<Integer> answer = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            arrTime[i] = (100-progresses[i])%speeds[i]==0 ? (100-progresses[i])/speeds[i] :(100-progresses[i])/speeds[i]+1 ;
        }
        int max=0;
        for(int i=0; i<arrTime.length; i++){
            if(arrTime[i] > max){
                max = arrTime[i];
                answer.offer(1);
            }else{
                ((LinkedList<Integer>) answer).set(answer.size()-1,((LinkedList<Integer>) answer).get(answer.size()-1)+1);
            }
        }

        int answerArr [] = new int[answer.size()];

        for(int i=0; i<answerArr.length; i++){
            answerArr[i] = answer.poll();
        }

        return answerArr;









    }
}
