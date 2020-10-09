package back4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int answer;
        int n=1;
        while(true){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l==0 && p==0 && v==0){
                break;
            }

            int num = v/p;
            int remain = v%p;
            answer = num*l;
            if(l > remain){
                answer+=remain;
            }else{
                answer+=l;
            }

            sb.append("Case "+n+": "+answer+"\n");
            n++;
        }

        System.out.println(sb.toString());
    }
}
