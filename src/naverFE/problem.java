package naverFE;


import java.util.ArrayList;
import java.util.Arrays;

public class problem {
    public static void main(String[] args) {
        String s = "abasaafdsafdsafbafmbqkejfbakjefbasfsddsfddddsfffeqrfeafdfadbsbsbsgfbsbsfbs";
        int v[] = {0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,5,0,1,2,3,4,5,0,1,2,3,4,5,0,1,2,3,4,5,43,212,21,21,43,23,8};
        int answer = solution(s,v);
        System.out.println(answer);
    }

//    public static String solution(String S, int K){
//        String day[] = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//        ArrayList<String> arrlist = new ArrayList<>(Arrays.asList(day));
//        int index = arrlist.indexOf(S);
//        int next = K%7;
//        String answer = arrlist.get((index+next)%7);
//        return answer;
//    }

    public static int solution(String S, int [] c){
        int bigValue = c[0];
        int answer=0;
        for(int i=0; i<S.length()-1; i++){
            int index = S.charAt(i)-'a';
            int indexnext = S.charAt(i+1)-'a';
            if(index==indexnext){
                if(bigValue < c[i+1]){
                    answer+=bigValue;
                    bigValue = c[i+1];

                }else{
                    answer+=c[i+1];
                }


            }else{
                bigValue = c[i+1];
            }
        }

        return answer;

    }
//    public static int solution(int N){
//
//        StringBuffer sb;
//        String digit="5";
//        String number = Math.abs(N)+"";
//        int numbers[] = new int[number.length()+1];
//
//        for(int i=0; i< number.length()+1;i++){
//            sb = new StringBuffer();
//            sb.append(number);
//            sb.insert(i,digit);
//            numbers[i] = Integer.parseInt(new String(sb));
//        }
//
//        Arrays.sort(numbers);
//        int result = N < 0 ? -numbers[0] : numbers[numbers.length-1];
//
//        return result;
//    }
}


