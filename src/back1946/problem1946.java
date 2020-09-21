package back1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1946 {
    static int arr[];
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int ansn = Integer.parseInt(br.readLine());

        for(int i=0; i<ansn; i++){
            num = Integer.parseInt(br.readLine());
            arr = new int[1+num];
            for(int k=0; k<num; k++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr [s] =e;
            }
            int limit = arr[1];
            int answer = 1;
            for(int k=2; k<=num; k++){
                if(arr[k] < limit){
                    answer++;
                    limit = arr[k];
                }
            }

            sb.append(answer+"\n");

        }

        System.out.println(sb.toString());


    }
}
