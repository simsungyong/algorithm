package back10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = n/300;
        int b = n/60;
        int c = n/10;
        boolean is = false;


        out: for(int i=a; i>=0; i--){
            for(int k=b; k>=0; k--){
                for(int l=c; l>=0; l--){
                    if(i*300+k*60+l*10 == n){
                        System.out.print(i+" "+k+" "+l);
                        is = true;
                        break out;
                    }
                }
            }
        }

        if(!is){
            System.out.println(-1);
        }


    }
}
