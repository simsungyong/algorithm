package back10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        String value = st.nextToken().toUpperCase();
        int answer[] = new int[26];

        Arrays.fill(answer,-1);
        for(int i =0; i<value.length(); i++){
            if(answer[value.charAt(i)-65] == -1){
                answer[value.charAt(i)-65] = i;
            }
        }


        for(int i =0; i<26; i++){
            System.out.print(answer[i]+" ");
        }

    }
}
