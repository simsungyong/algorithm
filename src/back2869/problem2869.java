package back2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2869 {
    static int a,b,v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int answer = search(0,v/(a-b)+1);
        System.out.print(answer);
    }
    public static int search(int left, int right){
        while(left < right){
            int mid = (left+right)/2;
            int sum = (mid-1)*(a-b);
            if(sum+a<v){
                left = mid+1;

            }else{
                right = mid;
            }

        }
        return right;
    }
}
