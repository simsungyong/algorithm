package back10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[10001];
        int max=0;
        for(int i=0; i<n; i++){
            int tmp =  Integer.parseInt(br.readLine());
            max = max < tmp ? tmp : max;
            arr[tmp] +=1 ;
        }

        for(int i=1; i<=max; i++){
            while(arr[i]>0){
                sb.append(i+"\n");
                arr[i] -=1;
            }
        }

        System.out.print(sb.toString());


    }



}


//왠만하면 println보다 Stringbuiler사용 시간 차이 큼.  30/0.9 정도