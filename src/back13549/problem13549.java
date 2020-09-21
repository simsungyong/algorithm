package back13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem13549 {
    static int target;
    static int start;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        dijkstra();
        System.out.println(arr[target]);

    }

    public static void dijkstra(){

        Queue<Integer> q = new LinkedList<>();
        arr[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int temp = q.poll();
            if((temp+1)<=100000 &&  arr[temp+1] > arr[temp]+1){
                arr[temp+1] = arr[temp]+1;
                q.add(temp+1);
            }

            if((temp-1 >=0) && arr[temp-1] > arr[temp]+1){
                arr[temp-1] = arr[temp]+1;
                q.add(temp-1);
            }

            if((2*temp) <= 100000 && arr[temp*2] > arr[temp]){
                arr[temp*2] = arr[temp];
                q.add(temp*2);
            }
        }

    }
}
