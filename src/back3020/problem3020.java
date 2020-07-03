package back3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int arrTop[] = new int[h+1];
        int arrBot[] = new int[h+1];
        int answerH=0;
        int num =200001;

        for(int i=0; i<n/2; i++){
            arrBot[Integer.parseInt(br.readLine())]++;
            arrTop[Integer.parseInt(br.readLine())]++;
        }


        for(int i =1; i<=h; i++){
            arrBot[i] = arrBot[i-1]+arrBot[i];
            arrTop[i] = arrTop[i-1]+arrTop[i];
        }
        for(int i =1; i<=h; i++){
            int tempsum=0;
            tempsum += arrBot[h]-arrBot[i-1];
            tempsum += arrTop[h] - arrTop[h-i];
            if(tempsum < num){
                num = tempsum;
                answerH=1;
            }else if(tempsum==num){
                answerH++;
            }
        }

        System.out.print(num+" "+answerH);



    }
}
