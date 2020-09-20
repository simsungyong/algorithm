package kakaoblind2018.프렌즈4블록.캐시;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class problem캐시 {
    public static void main(String[] args) {
        int c = 2;
//        String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String [] arr = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(c,arr));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            answer+=cities.length*5;
            return answer;
        }
        Set<String> set = new HashSet<>();
        LinkedList<String> list= new LinkedList<>();
        for(int i=0; i<cities.length;i++){

            String tmp = cities[i].toUpperCase();
            if(set.contains(tmp)){
                list.remove(tmp);
                list.addFirst(tmp);
                answer+=1;
            }else{
                if(set.size()==cacheSize){
                    String temp = list.removeLast();
                    set.remove(temp);
                }
                list.addFirst(tmp);
                set.add(tmp);
                answer+=5;
            }

        }
        return answer;
    }
}
