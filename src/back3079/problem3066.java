package back3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem3066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr ;
        StringBuilder sb  = new StringBuilder();
        int n;
        for(int i=0; i<test; i++){
            n= Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            for(int k=0; k<n; k++){
                int temp = Integer.parseInt(br.readLine());
                if(arr.size()==0 || arr.get(arr.size()-1) < temp){
                    arr.add(temp);
                }else{
                    int left = 0;
                    int right = arr.size()-1;
                    while(left < right){
                        int mid = (left+right)/2;
                        if(arr.get(mid) < temp){
                            left = mid+1;
                        }else{
                            right = mid;
                        }
                    }
                    arr.set(right, temp);
                }
            }

            sb.append(arr.size()+"\n");
        }


        System.out.println(sb.toString());
    }
}