package back2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        String m = st.nextToken();
        int check=0;
        for(int i=2; i>=0; i--){
            if((int)n.charAt(i) > (int)m.charAt(i)){
                check=1;
                break;
            }else if((int)n.charAt(i) == (int)m.charAt(i)){
                continue;
            }else{
                check=0;
                break;
            }
        }

        if(check==1){
            for(int i=2; i>= 0; i--){
                System.out.print(n.charAt(i));
            }
        }else{
            for(int i=2; i>= 0; i--){
                System.out.print(m.charAt(i));
            }
        }
    }
}
