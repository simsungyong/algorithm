package Samsung.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem퇴사 {
    static ArrayList<Integer>arr[];
    static int input[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
       // dp = new int[n+1];
        input = new int [n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            input[i+1] = cost;
            arr[time+i].add(i+1);
        }
        int lastindex=0;
        int max = 0;
        for(int i=1 ;i<=n; i++){
            if(arr[i].size()==0){
                continue;
            }
            for(int k=0; k<arr[k].size(); k++){

            }

        }

    }

}
