package back1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1753 {
    static int n,line,start;
    static ArrayList<Node> list[];
    static int dist[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int [n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }


        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
        }

        dijkstra();

        for(int i=1; i<=n; i++){
            if(dist[i]<Integer.MAX_VALUE){
                System.out.println(dist[i]);
            }
            else{
                System.out.println("INF");
            }
        }

    }
    public static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i =0; i<list[tmp.to].size(); i++){
                if(dist[list[tmp.to].get(i).to] > dist[tmp.to] + list[tmp.to].get(i).cost){
                    dist[list[tmp.to].get(i).to] = dist[tmp.to] + list[tmp.to].get(i).cost;
                    q.add(new Node(list[tmp.to].get(i).to,  dist[list[tmp.to].get(i).to]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to, cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
