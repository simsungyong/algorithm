package back1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int group = Integer.MAX_VALUE;
        int oneCost = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int groupcost = Integer.parseInt(st.nextToken());
            int one_co = Integer.parseInt(st.nextToken());
            group = Math.min(group,groupcost);
            oneCost = Math.min(oneCost, one_co);
        }

        int groupnum = n/6;
        int oneNum = n%6;


        if(oneCost*6 > group){
            answer += group*groupnum;
            if(oneNum*oneCost < group){
                answer += oneCost*oneNum;
            }else{
                answer += group;
            }

        }else{
            answer += oneCost*n;
        }

        System.out.print(answer);
    }
}
