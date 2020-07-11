package back5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        int answer=0;
        for(int i=0; i<arr.length; i++){
            int value = (arr[i]-'A');

            if(value<=17){
                answer+=((value/3)+2);
            }else if(value==18){
                answer+=7;
            }else if(value>=19 && value <22){
                answer+=8;
            }else if(value>=22 && value <26){
                answer+=9;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
