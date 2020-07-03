package back11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input[] = new int[n + 1];
        int result[] = new int[n + 1];
        int max;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            max= 0;
            for (int k = 0; k < n; k++) {
                if (input[i] > input[k]) {
                    max = result[k] > max ? result[k] : max;
                }
            }
            result[i] = max+1;
        }
        Arrays.sort(result);
        System.out.println(result[n]);
    }
}
