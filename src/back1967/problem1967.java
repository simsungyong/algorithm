package back1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1967 {
    static int n;
    static ArrayList<Node> list[];
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost));
            list[to].add(new Node(from,cost));
        }

        findMax(1);

        int max=0;
        int start=0;
        for(int i=1; i<=n; i++){
            if(max < dist[i]){
                max = dist[i];
                start = i;
            }
        }
        max=0;
        findMax(start);

        for(int i=1; i<=n; i++){
            if(max < dist[i]){
                max = dist[i];

            }
        }
        System.out.println(max);
    }

    public static void findMax(int start){
        boolean check [] = new boolean[n+1];
        dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<list[temp].size(); i++){
                int next = list[temp].get(i).to;
                int cost = list[temp].get(i).cost;
                if(check[next]==false){
                    dist[next] = dist[temp]+cost;
                    check[next] = true;
                    q.add(next);
                }
            }
        }
    }
}

class Node{
    int to,cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
