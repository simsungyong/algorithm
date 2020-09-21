package back11441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11441 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int v = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1]+v;
        }

        int ansnum = Integer.parseInt(br.readLine());

        for(int i=0; i<ansnum;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append((arr[e]-arr[s-1])+"\n");
        }

        System.out.println(sb.toString());
    }
}
