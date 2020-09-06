package back1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem1717 {
    static int n,line;
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int iszero = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(iszero==0){
                arr[a].add(b);
                arr[b].add(a);
            }
        }
    }
}
