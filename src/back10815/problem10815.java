package back10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int aArr[] = new int [n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        int testcase = Integer.parseInt(br.readLine());
        int testArr[] = new int [testcase];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<testcase; i++){
            testArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aArr);


        for(int i =0; i<testcase; i++){
            int answer=0;
            int max=n;
            int min=0;
            int middle;
            while (max - min > 1) {
                middle = (max+min)/2;
                //로직상 arr[0]값은 명시해줘야함
                if(testArr[i] == aArr[0]){
                    answer=1;
                    break;
                }
                if(testArr[i]==aArr[middle]){
                    answer=1;
                    break;
                }
                if(testArr[i]>aArr[middle]){
                    min = middle;
                }else if(testArr[i]<aArr[middle]){
                    max = middle;
                }
            }
            System.out.print(answer+" ");
        }


    }
}
