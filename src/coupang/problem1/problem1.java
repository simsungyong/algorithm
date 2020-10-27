package coupang.problem1;

import java.util.HashMap;
import java.util.Iterator;

public class problem1 {
    public static void main(String[] args) {
        int arr[] = {24,22,20,10,5,3,2,1};
        System.out.println(solution(3,arr));
    }

    public static int solution(int k, int[] score){
        int answer=score.length;
        HashMap<Integer, Integer> knum = new HashMap<>();

        Node arr[] = new Node[score.length];
        knum.put(Math.abs(score[0]-score[1]),1);

        boolean check[] = new boolean[score.length];
        arr[0] = new Node(Integer.MAX_VALUE,Math.abs(score[0]-score[1] ));
        arr[score.length-1] = new Node(Math.abs(score[score.length-2]-score[score.length-1]),Integer.MAX_VALUE);
        for(int i=1; i<score.length-1; i++){

            arr[i] = new Node(Math.abs(score[i-1]-score[i]),Math.abs(score[i]-score[i+1] ));
            int cntdiff = Math.abs(score[i]-score[i+1]);
            if(knum.containsKey(cntdiff)){
                knum.replace(cntdiff, knum.get(cntdiff)+1);
            }else{
                knum.put(cntdiff, 1);
            }



        }

        Iterator<Integer> keys = knum.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            if(knum.get(key)>=k){
                for(int i=0;i<score.length;i++){
                    if((arr[i].left == key || arr[i].right ==key) && !check[i] ){
                        answer--;
                        check[i] = true;
                    }
                }
            }
        }

        return answer;
    }
}

class Node{
    int left,right;
    Node(int left, int right){
        this.left= left;
        this.right = right;
    }
}
