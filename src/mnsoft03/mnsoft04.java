package mnsoft03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class mnsoft04 {
    public static void main(String[] args) {
        int mark [] = {1,2,3,1};
        solution(3,mark);

    }
    public static void solution(int num, int [] mark){
        int cnt=0;
        int circle=0;
        int beforeCircle=0;
        ArrayList<Integer> arr[]= new ArrayList[mark.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<mark.length; i++){
            arr[i] = new ArrayList<>();
            arr[i].add(mark[i]);
        }
        int cnt_people = 0;
        q.add(cnt_people);
        while(true){
            int next = arr[cnt_people].get(0);
            if(next == q.peek()){

            }else{
                q.add(next);
                cnt_people= next;
                circle++;
            }

        }
//        while(num > cnt){
//            cnt++;
//            cnt_people = arr[cnt_people].get(0);
//        }
        //System.out.println(cnt_people);

    }
}
