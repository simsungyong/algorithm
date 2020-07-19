package back2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2751 {
    public static void main(String[] args) throws IOException {
        boolean arr[] = new boolean[1000001];
        boolean arrminus[] = new boolean[1000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp >=0){
                arr[tmp] = true;
            }else{
                arrminus[-tmp] = true;
            }
        }

        for(int i=1000000; i>0; i--){
            if(arrminus[i]){
                sb.append(-i+"\n");
            }
        }

        for(int i=0; i<1000001; i++){
            if(arr[i]){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());

    }
}

// priorityqueue쓰면 시간초과남.;;;