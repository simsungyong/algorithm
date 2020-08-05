package back1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem1300 {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());


        int answer = search(0,1000000000);
        System.out.print(answer);
    }
    public static int search(int left, int right){
        int num;

        while(left <= right){
            num=0;
            int mid = (left+right)/2;
            for(int i=1; i<=n; i++){
                int cnt = mid/i;
                if(cnt > n){
                    num+=n;
                }else{
                    num+=cnt;
                }
            }
            if(num >= k){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return left;
    }
}

//n^2 으로 놓으면 오버플로우난다. 10억으로 놓고 해야한다. 조건이 k는 min(10^9, N2)보다 작거나 같은 자연수이다.
