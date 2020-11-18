package 베이글코드;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem03 {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3,3,2,2,3,3,3,3,2,2};
        System.out.println(solution(10, arr));

    }

    public static int solution(int n, int[] colors) {
        int answer = 0;
        String strinput = "";
        for(int a : colors){
            strinput += a;
        }


        PriorityQueue<Nodeq> q = new PriorityQueue<>();
        q.add(new Nodeq(strinput, 0));

        while(!q.isEmpty()){
            Nodeq tmp = q.poll();

            if(tmp.str.length()==0){
                answer = Math.max(answer,tmp.sum);
                continue;
            }



            char cnt = tmp.str.charAt(0);
            int startindex=0;
            String next="";
            for(int i=0; i<tmp.str.length(); i++){
                if(cnt != tmp.str.charAt(i)){
                    next = tmp.str.substring(0,startindex)+tmp.str.substring(i,tmp.str.length());
                    cnt = tmp.str.charAt(i);
                    q.add(new Nodeq(next,tmp.sum+(i-startindex)*(i-startindex)));
                    startindex = i;
                }else if(i==tmp.str.length()-1){
                    next = tmp.str.substring(0,startindex);
                    q.add(new Nodeq(next,tmp.sum+(tmp.str.length()-startindex)*(tmp.str.length()-startindex)));

                }
            }
        }


        return answer;
    }


}

class Nodeq implements Comparable<Nodeq>{
    String str;
    int sum;
    Nodeq(String str, int sum){
        this.str = str;
        this.sum = sum;
    }

    @Override
    public int compareTo(Nodeq o) {
        return o.sum - this.sum;
    }
}
