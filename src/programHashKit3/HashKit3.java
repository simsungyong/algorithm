package programHashKit3;

import java.util.HashMap;
import java.util.Map;

public class HashKit3 {
    public static void main(String[] args) {
        String [][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
        System.out.print(solution(arr));
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.replace(clothes[i][1], map.get(clothes[i][1])+1);
            }else{
                map.put(clothes[i][1], 1);
            }
        }

        for(String temp : map.keySet()){
            answer = answer * (map.get(temp)+1);
        }

        return answer-1;
    }
}
