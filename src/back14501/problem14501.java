package back14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int [2][n+1];
        int result [] = new int [n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i =1; i<=n; i++) {
            int temp[] = Arrays.copyOfRange(result, 0, i);
            Arrays.sort(temp);
            int max = temp[i - 1];
            if (arr[0][i] + i - 1 <= n) {
                result[arr[0][i] + i - 1] = result[arr[0][i] + i - 1] > arr[1][i] + max ? result[arr[0][i] + i - 1] : arr[1][i] + max;
            }
        }

        Arrays.sort(result);
        System.out.println(result[n]);
    }
}


//배열 자르고 정렬하는거 기억해두자 (시간관리)