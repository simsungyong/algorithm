package back11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem11779 {
    static ArrayList<Node> arr[];
    static int n,line;
    static int dist[];
    static int path[];
    static int start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stackq = new Stack<>();
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        dist = new int[n+1];
        path = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        line = Integer.parseInt(br.readLine());
        for(int i=0; i<line ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijk();
        System.out.println(dist[end]);
        int to = end;
        int from = path[end];


        while(true){

            stackq.push(to);

            if(to==start){
                break;
            }
            to = from;
            from = path[to];
        }

        System.out.println(stackq.size());
        while(!stackq.isEmpty()){
            System.out.print(stackq.pop()+" ");
        }

    }

    public static void dijk(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        dist[start]=0;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<arr[tmp.to].size(); i++){
                Node next = arr[tmp.to].get(i);
                if(dist[tmp.to]+next.cost < dist[next.to]){
                    dist[next.to] = dist[tmp.to]+next.cost;
                    path[next.to] = tmp.to;
                    q.add(new Node(next.to, next.cost));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int to,cost;
    Node(int to, int cost){
        this.to =to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
//깊이탐색으로하면 시간초과.