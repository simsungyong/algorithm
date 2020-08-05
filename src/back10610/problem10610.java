package back10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String arr[] = br.readLine().split("");
        Arrays.sort(arr);
        int sum=0;
        for(int i=arr.length-1; i>=0; i--){
            sum += Integer.parseInt(arr[i]);
            sb.append(arr[i]);
        }

        if(sum%3==0 && Integer.parseInt(arr[0])==0){
            System.out.print(sb.toString());
        }else{
            System.out.print(-1);
        }
    }
}
