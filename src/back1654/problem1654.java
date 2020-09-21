package back1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1654 {
    static int num, target;
    static int arr[];
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[num];
        max = 0;
        for(int i=0; i<num; i++) {
            int a = Integer.parseInt(br.readLine());
            max = Math.max(max,a);
            arr[i] = a;
        }

        search();

    }
    public static void search(){
        long left=0;
        long right = max;

        long n;

        while(left<= right){
            n=0;
            long mid = (left+right)/2;

            if(mid!=0){
                for(int i=0; i<num; i++){
                    n+=arr[i]/mid;
                }
            }

            if( mid == 0 || n >= target){
                left = mid+1;

            }else{
                right = mid-1;

            }

        }

        System.out.println(right);


    }

}
