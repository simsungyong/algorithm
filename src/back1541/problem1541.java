package back1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem1541 {
    static Queue<Integer> q_num=new LinkedList<>();
    static Queue<Integer> cal = new LinkedList<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int index = 0;
        answer = 0;

        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)-'0'<0){
                q_num.add(Integer.parseInt(a.substring(index,i)));
                cal.add(a.charAt(i)-'0');
                index = i+1;
            }
        }
        q_num.add(Integer.parseInt(a.substring(index,a.length())));
        solution();
    }

    public static void solution(){
        answer += q_num.poll();
        while(cal.size()>0){
            int cal_cnt = cal.poll();
            int sum = 0;
            if(cal_cnt==-3){
                sum -= q_num.poll();

                while(cal.size()>0 &&cal.peek()==-5 ){
                    cal.poll();
                    sum -= q_num.poll();
                }
                answer += sum;
                continue;
            }

            if(cal_cnt ==-5){
                sum+=q_num.poll();
                answer += sum;
                continue;
            }


        }

        System.out.print(answer);
    }
}
