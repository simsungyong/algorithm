package programHashKit2;

import java.util.*;

public class HashKit2 {
    public static void main(String[] args) {
        String arr [] = {"42432","119", "97674223", "2195524421","422432213", "119141412412"};
        System.out.println(solution(arr));
    }


    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], 2);
        }
        for(int i=0; i<phone_book.length; i++){
            for(String temp : map.keySet()){
                if(temp.length() >= phone_book[i].length()){
                    if(temp.substring(0,phone_book[i].length()).equals(phone_book[i])){
                        System.out.println(phone_book[i]+" "+ temp.substring(0,phone_book[i].length()));
                        int c = map.get(temp);
                        if(c==1){
                            return false;
                        }
                        map.replace(temp, c-1);
                    }
                }
            }
        }


        return answer;
    }
}




