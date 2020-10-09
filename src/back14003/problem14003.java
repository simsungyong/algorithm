package back14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arrindex[] = new int[n];
        int input[] = new int[n];
        ArrayList<Integer> arr= new ArrayList<>();
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int v = Integer.parseInt(st.nextToken());
            input[i] = v;
            if(arr.size()==0 || arr.get(arr.size()-1) < v){
                arr.add(v);
                arrindex[i] = arr.size()-1;
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
                arrindex[i] = right;
            }

        }
        int size = arr.size()-1;
        for(int i=n-1; i>=0; i--){
            if(arrindex[i] == size){
                sb.append(input[i]+" ");
                size--;
            }
        }

        System.out.println(arr.size());
        String answer[] = sb.toString().split(" ");
        for(int i=answer.length-1; i>=0; i--){
            System.out.print(answer[i]+" ");
        }

    }
}
