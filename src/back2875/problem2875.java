package back2875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = m;
        while(cnt > 0){
            if(cnt*2 <= n && ((m-cnt)+(n-cnt*2))>=k){
                break;
            }

            cnt -= 1;
        }

        System.out.print(cnt);
    }
}
