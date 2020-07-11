package back17448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem17448 {
    static sorted list[];
    static int k,n;
    static int absmax;
    static long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new sorted[n];
        dp = new long[k+1];
        absmax = 0 ;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = new sorted(Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(list);

        dp[1] = -list[0].x;


       // System.out.println(max%(1000000000+7));

    }

    public static void search(){
        for(int i=1; i<=n; i++){
            int tmp = list[i].x;
            if(tmp>0){

            }else{

            }

        }


    }
}
class sorted implements Comparable<sorted>{

    int x;
    sorted(int x){
        this.x=x;
    }
    @Override
    public int compareTo(sorted o) {
        return Math.abs(o.x)-Math.abs(this.x);
    }
}

//dfs시간초과난다~