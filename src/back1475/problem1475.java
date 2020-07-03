package back1475;

import java.util.Arrays;
import java.util.Scanner;

public class problem1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int arr [] = new int[9];
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)-'0' == 9 ){
                arr[6]++;
            }
            else{
                arr[input.charAt(i)-'0']++;
            }
        }


        arr[6] = arr[6]%2 ==1 ? (arr[6]+1)/2 : arr[6]/2;
        Arrays.sort(arr);
        System.out.println(arr[8]);



    }
}


//알아놓자!
//string.charAt(i) - '0'converts it to an integer.