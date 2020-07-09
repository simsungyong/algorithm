package back2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2805 {
    static int list[];
    static int n;
    static int limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list= new int[n];
        limit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        search();
    }
    public static void search(){
        int left=0;
        int right = list[n-1];
        long sum=0;
        while(left<= right){
            int mid = (left+right)/2;
            sum=0;
            for(int i=0; i<n; i++){
                if(list[i]-mid > 0){
                    sum+=(list[i]-mid);
                }
            }
            if(sum >= limit){
                left = mid+1;

            }else{
                right = mid-1;

            }

        }

        System.out.println(right);


    }
}
