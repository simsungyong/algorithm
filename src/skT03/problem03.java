package skT03;

import java.util.ArrayList;
import java.util.List;

public class problem03 {
    public static void main(String[] args) {
        int answer = solution("bbababbba");
        System.out.println(answer);
    }
    public static int solution(String s){
        if(s.length()<3){
            return 0;
        }
        char [] words = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            if(words[i] =='a'){
                list.add(i);
            }
        }

        if(list.size() != 0 && list.size()%3 != 0){
            return 0;
        }else if(list.size() ==0){
            return (words.length-1)*(words.length-2)/2;
        }

        int interval = list.size()/2;
        return (list.get(interval)-list.get(interval-1))*(list.get(interval*2)-list.get(interval*2-1));
    }
}
