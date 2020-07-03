package back11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result [] = new int [n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            result[i] = Integer.parseInt(st.nextToken());

        }

        if(n<2){
            System.out.println(result[1]);
        }else{

            for(int i=2; i<=n; i++){
                for(int k=0; k<=i/2; k++){
                    int temp = result[k]+result[i-k];
                    if(result[i] < temp){
                        result[i] = temp;
                    }
                }
            }
        }


        System.out.println(result[n]);
    }
}
