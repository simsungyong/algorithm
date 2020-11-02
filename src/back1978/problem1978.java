package back1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer=0;
        for(int i=0; i<n; i++){
            int temp  = Integer.parseInt(st.nextToken());

            if(temp==2){
                answer++;
            }else{
                if(temp!=1 && check(temp)){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
    public static boolean check(int n){
        for(int i=2; i<n;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}
