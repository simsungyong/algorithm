package back1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class proeblm1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                if(i==0){
                    a[k] = Integer.parseInt(st.nextToken());
                }else{
                    b[k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int answer=0;
        for(int i=0; i<n; i++){
            answer += a[n-i-1]*b[i];
        }
        System.out.println(answer);

    }
}
