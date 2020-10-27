package back18353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(arr.size()==0 || arr.get(arr.size()-1) > temp){
                arr.add(temp);
            }else{
                int left = 0;
                int right = arr.size()-1;
                while(left < right){
                    int mid = (left+right)/2;
                    if(arr.get(mid) > temp){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                arr.set(right, temp);
            }
        }

        System.out.println(n- arr.size());
    }
}
