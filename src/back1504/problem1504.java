package back1504;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1504 {
    static int value[];
    private static final int INF = 200_000_000;
    static ArrayList<Node> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
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
            list[b].add(new Node(a,c));
        }
        int s1,s2;
        st = new StringTokenizer(br.readLine());
        s1 = Integer.parseInt(st.nextToken());
        s2 = Integer.parseInt(st.nextToken());



        int answer1 = dijkstra(1,s1)+dijkstra(s1,s2)+dijkstra(s2,n);
        int answer2 = dijkstra(1,s2)+dijkstra(s2,s1)+dijkstra(s1,n);
        if(answer1 >= INF && answer2>=INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(answer1,answer2));
        }

    }

    public static int dijkstra(int start, int end){
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



        return value[end];
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
