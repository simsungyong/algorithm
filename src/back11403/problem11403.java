package back11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        int result[][] = new int[n][n];

        for(int i=0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i< n; i++){
            Queue<Integer> queue= new LinkedList<>();
            boolean check [] = new boolean[n];
            queue.add(i);
            while(!queue.isEmpty()){
                int start = queue.poll();
                for(int k=0; k<n; k++){
                    if(arr[start][k] == 1 && check[k]!= true){
                        check[k] = true;
                        result[i][k] =1;
                        queue.add(k);
                    }
                }

            }
        }

        for(int i =0; i<n; i++) {
            for (int k = 0; k < n; k++) {
                System.out.print(result[i][k]+" ");
            }
            System.out.println();
        }

    }
}
/*
bfs 이어진 노드 있으면 큐에 넣고, 하나씩 빼면서 탐색.
지나가면서 지나간 노드인지 체크.
 */