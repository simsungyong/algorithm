package programStack4;

import java.util.LinkedList;
import java.util.Queue;

public class problemPrint {
    public static void main(String[] args) {
        int priorties [] = {3,2,9,4,2,1};
        int answer = solution(priorties, 5);
        System.out.print(answer );

    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<SetPrint> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new SetPrint(priorities[i],i));
        }

        while(true){
            SetPrint s = q.poll();
            if(q.size()==0){
                answer++;
                return answer;

            }else{
                for(int i=0; i<q.size(); i++){
                    if(s.weight < ((LinkedList<SetPrint>) q).get(i).weight){

                        ((LinkedList<SetPrint>) q).offerLast(s);
                        break;
                    }

                    if(i==q.size()-1){
                        answer++;
                    }
                }


                if(s.index == location && ((LinkedList<SetPrint>) q).get(q.size()-1).index != location){
                    break;
                }

            }

        }

        return answer;
    }

    static class SetPrint{
        int weight;
        int index;
        SetPrint(int weight, int index){
            this.weight = weight;
            this.index = index;
        }
    }
}

