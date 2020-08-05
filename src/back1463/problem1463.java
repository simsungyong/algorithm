package back1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1463 {
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        int arr[] = new int[n+1];



        for(int i=1; i<=n; i++){
            if(i==1){
                arr[i]=0;
                continue;
            }
            if(i==2 || i==3){
                arr[i] = 1;
                continue;
            }

            if(i%3 !=0 && i%2!=0){
                arr[i] = arr[i-1]+1;
                continue;
            }

            if(i%3==0){
                if(i%2==0){
                    arr[i] = Math.min( Math.min(arr[i/3], arr[i/2]), arr[i-1])+1;
                }else{
                    arr[i] = Math.min(arr[i/3], arr[i-1])+1;
                }
            }else{
                arr[i] = Math.min(arr[i/2], arr[i-1])+1;
            }
        }


        System.out.print(arr[n]);

    }


}
