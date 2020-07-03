package back2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int sum = 0;
        int skip = 0;

        for(int i=0; i<input.length(); i++){
            if(skip==0){
                if(input.charAt(i) == 'c' || input.charAt(i) == 'l' || input.charAt(i) == 'n' || input.charAt(i) == 's' || input.charAt(i) == 'z' ){
                    skip =1;
                    sum++;
                }
                else if(input.charAt(i) == 'd'){
                    if(input.charAt(i+1) == 'z'){
                        sum++;
                        skip =2;
                    }else if(input.charAt(i+1) == '-'){
                        sum++;
                        skip =1;
                    }else{
                        sum++;
                    }
                }
                else{
                    sum++;
                }
            }
            else{
                skip = skip - 1;
            }
        }

        System.out.println(sum);

    }
}
