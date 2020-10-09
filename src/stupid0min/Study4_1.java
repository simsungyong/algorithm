package stupid0min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Card arr[]= new Card[5];

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Card(a,b);
        }

        for(int i=0; i<5; i++){
            System.out.println(arr[i].first+" "+arr[i].second);
        }
    }
}


class Card {
    int first,second;

    Card(int first, int second){
        this.first = first;
        this.second = second;
    }
}


//class Made{
//    int tire1, tire2,tire3,tire4, body;
//
//    Made(int tire1, int tire2, int tire3, int tire4){
//        this.tire1 = tire1;
//        this.tire2 = tire2;
//        this.tire3 = tire3;
//        this.tire4 = tire4;
//    }
//
//    public void madetire(){
//        body = tire1+tire2+tire3+tire4;
//        System.out.println(body);
//        System.out.println("타이어조립을 완료하였습니다.");
//    }
//
//    public void 바디강화(){
//        body += 10;
//        System.out.println(body);
//        System.out.println("바디를 강화하였습니다.");
//    }
//}