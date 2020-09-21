package back18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem18352 {
    static int city, road, target, start;
    static int arr[];
    static ArrayList<Integer> []list;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        city = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());
        arr = new int[city+1];
        list = new ArrayList[city+1];
        for(int i=1; i<=city; i++){
            arr[i]  = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<road; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        dijkstra();
        for(int i=1; i<=city; i++){
            if(arr[i] == target){
                sb.append(i+"\n");
            }
        }

        if(sb.toString().length()==0){
            System.out.println(-1);
        }else{
            System.out.println(sb.toString());
        }




    }

    public static void dijkstra(){
        Queue<Integer> q = new LinkedList<>();
        arr[start] = 0;
        q.add(start);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<list[temp].size(); i++){
                int next = list[temp].get(i);
                if(arr[next] > arr[temp]+1){
                    arr[next] = arr[temp]+1;
                    q.add(next);
                }
            }
        }

    }
}
