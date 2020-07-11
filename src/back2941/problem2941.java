package back2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int length = input.length();
        input +="00";

        int count=0;
        int index=0;
        while(index<length){
            if(input.charAt(index)=='c'){
                if(input.charAt(index+1)=='=' ||input.charAt(index+1)=='-'){
                    count++;
                    index = index+2;
                }else{
                    count++;
                    index++;
                }
            }else if(input.charAt(index)=='d' ){
                if(input.charAt(index+1)=='z'  &&input.charAt(index+2)=='='){
                    count++;
                    index = index+3;
                }else if(input.charAt(index+1)=='-' ){
                    count++;
                    index = index+2;
                }
                else{
                    count++;
                    index++;
                }
            }

            else if((input.charAt(index)=='s' || input.charAt(index)=='z') && input.charAt(index+1)=='=' ){
                count++;
                index = index+2;
            }
            else if((input.charAt(index)=='l' || input.charAt(index)=='n') && input.charAt(index+1)=='j' ){
                count++;
                index = index+2;
            }

            else{
                count++;
                index++;
            }
        }


        System.out.println(count);
        br.close();
    }
}//런타임에러조심
