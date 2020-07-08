package back2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2512 {
    static int list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n];

        int b = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int limit = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            if(limit > list[i]*(n-i)){
                limit = limit - list[i];
            }else{
                b = limit/(n-i);
                break;
            }
        }
        if(b==0){
            b = list[n-1];
        }

        System.out.println(b);




    }


}
