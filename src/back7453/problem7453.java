package back7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem7453 {
    static int arr[][];
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[2][4];
        for(int i=0;i<2;i++){
            for(int k=0; k<4; k++){
                if(i==0) arr[i][k] = Integer.MAX_VALUE;
                else arr[i][k] = Integer.MIN_VALUE;
            }
        }
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0; k<4; k++){
                int cnt = Integer.parseInt(st.nextToken());
                arr[0][k] = Math.min(arr[0][k],cnt);
                arr[1][k] = Math.max(arr[1][k],cnt);
            }
        }
    }
    public static void solution(int index, int upper_bound, int under_bound){

    }
}
