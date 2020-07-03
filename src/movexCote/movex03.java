package movexCote;

import java.util.Arrays;

public class movex03 {
    public static void main(String[] args) {
        int price [] = {5,2,8,4,1,7,12,15,30,4,60};
        solution(price);
    }
    public static void solution(int [] prices){
        int answer=-1;
        for(int i=0; i<prices.length-1; i++){
            int [] temparr = new int[prices.length-i-1];
            System.arraycopy(prices,i+1,temparr,0, prices.length-i-1);
            Arrays.sort(temparr);
            int cnt = temparr[temparr.length-1] - prices[i];
            answer = (answer > cnt) ? answer : cnt;
        }
        if(answer < 0 ){
            answer = 0;
        }
        System.out.println(answer);
    }
}


