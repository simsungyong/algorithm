package back1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem1339 {
    static double arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr= new double[26];


        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int k=0; k<temp.length(); k++){
                arr[temp.charAt(k)-'A']+=Math.pow(10,temp.length()-(k+1));
            }
        }
        Arrays.sort(arr);
        int start = 9;
        int answer=0;
        for(int i=25; i>=0; i--){
            if(arr[i]==0){
                break;
            }
            answer+=arr[i]*start;
            start--;
        }

        System.out.println(answer);





//        System.out.println(answer);


    }
}
