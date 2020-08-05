package back5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5557 {
    static int n;
    static int arr[];
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(0,arr[0]);
        System.out.print(answer);


    }
    public static void solution(int index, long value){
        if(index==n-2){
            if(value == arr[n-1]){
                answer++;
            }
            return;
        }

        if(value - arr[index+1] >=0){
            solution(index+1, value-arr[index+1]);
        }

        if(value + arr[index+1] <= 20){
            solution(index+1, value+arr[index+1]);

    }
}
}
