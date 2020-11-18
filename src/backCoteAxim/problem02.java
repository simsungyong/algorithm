package backCoteAxim;


import java.util.ArrayList;


public class problem02 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFHG"));
    }
    public static String solution(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        char temp = s.charAt(s.length()-1);
        arr.add(temp);

        String answer="";
        for(int i=s.length()-2; i>=0; i--){
            char cnt = s.charAt(i);

            if(temp-'A' <= cnt-'A'){
                temp = cnt;
                arr.add(cnt);
            }else{
                answer = s.substring(0,i);
                temp = cnt;
                break;
            }
        }

        if(arr.size()==s.length()) return s;

        int index=0;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)-'A' > temp-'A'){
                index = i;
                break;
            }
        }

        answer+=arr.get(index);
        for(int i=0; i<arr.size(); i++){
            if(i==index){
                answer+=temp;
            }else{
                answer+=arr.get(i);
            }
        }

        return answer;

    }
}
