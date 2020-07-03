package programGreedy2;

import java.util.Arrays;

public class problem2 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k=4;
        System.out.print(solution(number,k));

    }

    public static String solution(String number, int k) {
        StringBuilder answer =  new StringBuilder(); //시간 초과 막기위해
        int haveto = number.length()-k;
        int index=0;


            for (int i = 0; i < number.length() - k; i++) {
                if (index == number.length()) {
                    answer.append(number.substring(index - 1, index));

                    break;
                } else {
                    char arr[] = number.substring(index, number.length() - haveto + 1).toCharArray();
                    Arrays.sort(arr);
                    answer.append(arr[arr.length-1]);
                    index = number.indexOf(String.valueOf(arr[arr.length - 1]), index) + 1;
                    haveto = haveto - 1;
                }


            }
        return answer.toString();
    }
}
