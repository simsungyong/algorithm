package back2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem2751 {
    public static void main(String[] args) throws IOException {
        boolean arr[] = new boolean[1000001];
        boolean arrminus[] = new boolean[1000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                System.out.println(-i);
            }
        }

        for(int i=0; i<1000001; i++){
            if(arr[i]){
                System.out.println(i);
            }
        }
    }
}

// priorityqueue쓰면 시간초과남.;;;