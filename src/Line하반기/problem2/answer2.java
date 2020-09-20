package Line하반기.problem2;

import java.util.*;

public class answer2 {
    static Set<Integer> set;
    static LinkedList<Integer> list;
    static ArrayList<Integer> answerlist;
    public static void main(String[] args) {
        int [] ball = {11, 2, 9, 13, 24};
        int [] order = {9,2,13,24,11};


        solution(ball, order);
    }

    public static int[] solution(int[] ball, int[] order) {
        set = new HashSet<>();
        list= new LinkedList<>();
        answerlist = new ArrayList<>();
        for(int i=0; i<ball.length; i++){
            list.add(ball[i]);
        }

        for(int i=0; i< order.length; i++){
            if(list.getFirst()==order[i]){
                list.removeFirst();
                answerlist.add(order[i]);
                subCheck(0);
            }else if(list.getLast()==order[i]){
                list.removeLast();
                answerlist.add(order[i]);
                subCheck(1);
            }else{
                set.add(order[i]);
            }
        }
        int answer[] = new int[ball.length];
        for(int i=0; i<answerlist.size(); i++){
            answer[i] = answerlist.get(i);
            System.out.print(answer[i]+" ");
        }


        return answer;
    }

    public static void subCheck(int isLeft){
        if(list.isEmpty()){
            return;
        }
        int temp;

        if(isLeft==0){
            temp = list.getFirst();
            if(set.contains(temp)){
                list.removeFirst();
                answerlist.add(temp);
                subCheck(isLeft);
            }

        }else{
            temp = list.getLast();
            if(set.contains(temp)){
                list.removeLast();
                answerlist.add(temp);

                subCheck(isLeft);
            }
        }


    }
}


