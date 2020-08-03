package TossTest02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean check [] = new boolean[45];
        boolean answer= true;
        int before=0;
        int num=0;
        while(st.hasMoreTokens()){
            int cnt = Integer.parseInt(st.nextToken());

            if(cnt >= 46 || cnt <=0){
                answer = false;
                break;
            }

            if(check[cnt]){
                answer = false;
                break;
            }
            if(before > cnt){
                answer = false;
                break;
            }

            before = cnt;
            check[cnt] = true;
            num++;
        }

        if(num!=6){
            answer =false;
        }

        System.out.print(answer);

    }
}
