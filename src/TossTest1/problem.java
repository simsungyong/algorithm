package TossTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean answer = true;
        boolean isTwo = false;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)-'0'==1){
                if(i == input.length()-1 ){
                    answer = false;
                    break;
                }

                if(isTwo){
                    answer = false;
                    break;
                }

                if(i < input.length()-1 && input.charAt(i+1)-'0'!=2){
                    answer = false;
                    break;
                }else{
                    isTwo = true;
                }
            }
        }
        System.out.print(answer);

    }
}
