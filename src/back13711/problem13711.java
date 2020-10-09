package back13711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem13711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[n];

        ArrayList<Integer> commonarr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
                int temp = Integer.parseInt(st.nextToken());
                map.put(temp,i);
            }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = map.get(Integer.parseInt(st.nextToken()));
        }



        for(int i=0; i<n; i++){
            int v = arr[i];
            if(commonarr.size()==0 || commonarr.get(commonarr.size()-1) < v){
                commonarr.add(v);
            }else{
                int left =0;
                int right = commonarr.size()-1;

                while(left<right){
                    int mid = (left+right)/2;
                    if(commonarr.get(mid) < v){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }

                commonarr.set(right,v);
            }

        }


        System.out.println(commonarr.size());


    }
}
