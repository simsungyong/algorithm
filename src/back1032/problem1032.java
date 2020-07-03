package back1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = new String[n];
        for(int i=0; i<n; i++){
            input[i] = br.readLine();
        }


        char ansarr [] = new char [input[0].length()];
        for(int i=0; i<ansarr.length; i++) {
            char cnt = input[0].charAt(i);
            for (int k = 1; k < n; k++) {
                int temp = input[k].charAt(i);
                if(cnt != temp){
                    ansarr[i] = '?';
                    break;
                }
            }
            if(ansarr[i] != '?'){
                ansarr[i] = cnt;
            }
        }

        for(int i=0; i<ansarr.length; i++){
            System.out.print(ansarr[i]);
        }



    }
}
