package back3047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr[] = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine(),"");
        String input = st.nextToken();
        for(int i=0; i<3; i++){
            switch (input.charAt(i)){
                case 'A': System.out.print(arr[0]+" ");
                break;
                case 'B': System.out.print(arr[1]+" ");
                break;
                case 'C': System.out.print(arr[2]+" ");
                break;
            }

        }

    }
}
