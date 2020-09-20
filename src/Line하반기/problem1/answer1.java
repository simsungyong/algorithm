package Line하반기.problem1;

import java.util.HashMap;
import java.util.Iterator;

public class answer1 {
    public static void main(String[] args) {
        int [][] input = {{3,1},{2,2},{1,4},{5,6},{2,5},{6,3},{3,4},{3,5}};
        solution(input);
    }

    public static int solution(int[][] boxes) {
        int answer;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<boxes.length; i++){
            for(int k=0; k<2; k++){
                if(map.containsKey(boxes[i][k])){
                    map.replace(boxes[i][k], map.get(boxes[i][k])+1);
                    continue;
                }

                map.put(boxes[i][k],1);
            }
        }

        Iterator<Integer> iter = map.keySet().iterator();
        int num=0;
        while(iter.hasNext()){
            int plus = iter.next();
            num += (map.get(plus)/2);
        }
        answer = boxes.length-num;

        return answer;
    }
}
