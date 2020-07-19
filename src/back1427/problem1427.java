package back1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str[] = br.readLine().split("");
        Arrays.sort(str);
        for(int i=str.length-1; i>=0; i-- ){
            sb.append(str[i]);
        }

        System.out.println(sb.toString());

    }
}


