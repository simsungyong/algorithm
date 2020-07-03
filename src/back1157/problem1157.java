package back1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        int arr [] = new int[26];
        int max=0;
        char result = '?';
        for(int i=0; i<input.length(); i++){
            arr[input.charAt(i) - 65]++;
            if(max < arr[input.charAt(i)-65]){
                max = arr[input.charAt(i)-65];
                result = input.charAt(i);
            }
            else if(max == arr[input.charAt(i)-65]){
                result ='?';
            }
        }

        System.out.print(result);





        }
}
