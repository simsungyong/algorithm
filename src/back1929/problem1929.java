package back1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean numcheck[] = new boolean[1000001];
        numcheck[1] = true;
        for(int i=2; i<=end; i++){
            if(!numcheck[i]){
                for(int k=2; k*i<=1000000; k++){
                    numcheck[i*k] = true;
                }
            }
        }

        for(int i=start; i<=end; i++){
            if(!numcheck[i]){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());

    }


}
