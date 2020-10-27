package back2550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem2550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> commonarr = new ArrayList<>();

        int arr[] = new int[n];
        int light[] = new int[n];
        int index[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i-1] = tmp;
            map.put(tmp, i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            light[i] = map.get(Integer.parseInt(st.nextToken()));
        }


        for(int i=0; i<n; i++){
            int v = light[i];
            if(commonarr.size()==0 || commonarr.get(commonarr.size()-1) < v){
                commonarr.add(v);
                index[i] = commonarr.size()-1;

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
                index[i] = right;
            }

        }

        System.out.println(commonarr.size());
        int size = commonarr.size();
        int answer[] = new int[size];
        for(int i=n-1; i>=0; i--){
            if(index[i]==size-1){
                answer[size-1] = arr[light[i]-1];
                size--;
            }
        }

        Arrays.sort(answer);
        for(int a : answer){
            System.out.print(a+" ");
        }

    }
}
