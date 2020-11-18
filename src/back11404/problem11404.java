package back11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem11404 {
    static int n;
    private static final int INF = 200_000_000;
    static ArrayList<Node> list[];
    static int value[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n =Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        list= new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        value = new int[n+1];
        for(int i=0; i<line; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }

        for(int i=1; i<=n; i++){
            dijkstra(i);
            System.out.println();
        }


    }

    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(value, INF);
        value[start] = 0;
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<list[tmp.to].size(); i++){
                Node next = list[tmp.to].get(i);
                if(value[next.to] > value[tmp.to]+next.v){
                    value[next.to] = value[tmp.to]+next.v;
                    q.add(new Node(next.to,value[next.to]));
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(value[i]==INF){
                System.out.print(0+" ");
            }else{
                System.out.print(value[i]+" ");
            }
        }


    }
}
class Node implements Comparable<Node>{
    int to, v;
    Node(int to, int v){
        this.to=to;
        this.v=v;
    }

    @Override
    public int compareTo(Node o) {
        return this.v-o.v;
    }
}
