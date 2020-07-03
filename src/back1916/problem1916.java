package back1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1916 {
    static int n;
    static ArrayList<Node> list[];
    static int start, end;
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        temp = new int[n+1];
        Arrays.fill(temp,Integer.MAX_VALUE);
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();

        }

        for(int i=0; i<bus; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end =Integer.parseInt(st.nextToken());


        dijkstra(start);

        System.out.println(temp[end]);



    }
    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(start,0));
        temp[start] = 0;

        while(!q.isEmpty()){
            Node cnt = q.poll();

            for(int i=0; i<list[cnt.to].size(); i++){
                int next = list[cnt.to].get(i).to;
                int cost = list[cnt.to].get(i).cost;

                if(temp[next] > temp[cnt.to] + cost){
                    temp[next] = temp[cnt.to]+cost;
                    q.add(new Node(next,temp[next]));
                }


            }
        }
    }
}
class Node implements Comparable<Node> {
    int to;
    int cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }



    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}