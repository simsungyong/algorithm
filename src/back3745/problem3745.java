package back3745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem3745 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr;
        while(sc.hasNext()){

            int n = sc.nextInt();
            arr = new ArrayList<>();

            for(int i=0; i<n; i++){
                int v = sc.nextInt();
                if(arr.size()==0 || arr.get(arr.size()-1) < v){
                    arr.add(v);
                }else{
                    int left =0;
                    int right = arr.size()-1;

                    while(left<right){
                        int mid = (left+right)/2;
                        if(arr.get(mid) < v){
                            left = mid+1;
                        }else{
                            right = mid;
                        }
                    }

                    arr.set(right,v);
                }

            }
            System.out.println(arr.size());
        }

    }
}
