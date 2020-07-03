package ngvCote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ngvCote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        long result=0;
        String val = br.readLine();

        for(int i=0; i<= n-len; i++){
            long temp = Long.parseLong(val.substring(i,i+len));
            result = result < temp ? temp : result;

        }
        System.out.println(result);

    }
}
