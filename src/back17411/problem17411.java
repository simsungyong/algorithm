package back17411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem17411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arrindex[] = new int[n];
        ArrayList<Integer> arr= new ArrayList<>();
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int v = Integer.parseInt(st.nextToken());
            if (arr.size() == 0 || arr.get(arr.size()-1) < v) {
                arr.add(v);
                arrindex[arr.size()-1]++;
            }else{
                int left = 0;
                int right = arr.size()-1;
                while(left < right){
                    int mid = (left+right)/2;
                    if(arr.get(mid) < v){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }

                arr.set(right, v);
                arrindex[right]++;
            }
        }

//        int answer=0;
//        for(int i=n-1; i>=0; i--){
//            arrindex[]
//        }
    }
}
//아직못품 ㅜㅜㅜ