package back14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem14888 {
    static int n;
    static int num[];
    static int cal[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        cal = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1,num[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void backtrack(int step, int answer){
        if(step == n){
            max = Math.max(max, answer);
            min = Math.min(min, answer);
            return;
        }

            for(int i=0; i<4; i++){
                if(cal[i]>0){
                    cal[i] = cal[i]-1;
                    if(i==0){
                        backtrack(step+1, answer+num[step]);
                    }else if(i==1){
                        backtrack(step+1, answer-num[step]);
                    }else if(i==2){
                        backtrack(step+1, answer*num[step]);
                    }else{
                        backtrack(step+1, answer/num[step]);
                    }
                    cal[i] = cal[i]+1;
                }
        }


    }

}
