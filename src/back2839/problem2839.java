package back2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int five = n/5;
        int tree = n/3;
        int answer = 0;

        out:for(int i=five; i>=0; i--){
            for(int k=0; k<=tree; k++){
                if(i*5+k*3 == n){
                    answer = i+k;
                    break out;
                }
            }
        }
        if(answer==0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }


    }
}
