package back1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue();
        for(int i=0; i<n; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;



        while(q.size()!=1){
            int a = q.poll();
            int b = q.poll();
            q.add(a+b);
            sum = sum+a+b;
        }

        System.out.println(sum);
    }
}
