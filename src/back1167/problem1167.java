package back1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1167 {
    static int n;
    static ArrayList<Node> list[];
    static int distance[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        distance = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1){
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to,cost));
            }
        }
        int start = 1;
        int Max = 0;
        findMax(start);

        for(int i=1; i<=n; i++){
            if(Max < distance[i]){
                Max = distance[i];
                start = i;
            }
        }
        Max=0;

        findMax(start);
        for(int i=1; i<=n; i++){
            if(Max < distance[i]){
                Max = distance[i];
            }
        }
        System.out.println(Max);




    }
    public static void findMax(int start){
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean check[] = new boolean[n+1];
        distance[start] = 0;
        check[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<list[tmp].size(); i++){
                int next = list[tmp].get(i).to;
                int cost = list[tmp].get(i).cost;
                if(check[next] == false){
                    distance[next] = distance[tmp] + cost;
                    check[next] = true;
                    q.add(next);
                }
            }
        }
    }
}

class Node {
    int to,cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
