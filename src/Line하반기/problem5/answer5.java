package Line하반기.problem5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class answer5 {
    static int index=0;
    static int sumP,sumD;
    static boolean oneP, oneD;
    public static void main(String[] args) {
        int input[] = {1, 4, 10, 6, 9, 1, 8, 13};
    }

    public static int solution(int[] cards) {
        int answer = 0;

        while(true){
            oneD=false;
            oneP=false;
            start(index, cards);


            if( oneP && sumP==11){
                if(!(oneD && sumD==11)){
                    answer+=3;
                }
                continue;
            }



            break;

        }
        return answer;
    }

    public static void start(int i, int [] cards){
        int tempindex = i;
        for(int k=tempindex-i; k<4; k++){
            if(k%2==0){
                if(cards[i+k]>10){
                    sumP +=10;
                }else{
                    sumP +=cards[i+k];
                }

                if(cards[i+k]==1){
                    oneP =true;
                }
            }else{
                if(cards[i+k]>10){
                    sumD +=10;
                }else{
                    sumD +=cards[i+k];
                }

                if(cards[i+k]==1){
                    oneD = true;
                }
            }
        }


    }
}
