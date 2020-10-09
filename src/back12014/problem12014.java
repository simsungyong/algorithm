package back12014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem12014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr;
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int k=0; k<num; k++){
                int v = Integer.parseInt(st.nextToken());
                if(arr.size()==0 || arr.get(arr.size()-1) < v){
                    arr.add(v);
                }else{
                    int left = 0;
                    int right = arr.size()-1;
                    while(left < right){
                        int mid = (left+right)/2;
                        if(arr.get(mid) < v) {
                            left = mid+1;
                        }else{
                            right = mid;
                        }
                    }

                    arr.set(right, v);
                }
            }

            sb.append("Case #"+i+"\n");
            if(arr.size() >= limit){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }




        }

        System.out.println(sb.toString());


    }
}
