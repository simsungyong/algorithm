package back2307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2307 {
    static int n,m;
    static ArrayList<Node> arr[];
    static int dist[];
    static int path[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        path = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,t));
            arr[b].add(new Node(a,t));
        }

        dist[1] = 0;
        dijk(1);
        int max = dist[n];
        int max_se = dijk_se();
        if(max_se==-1){
            System.out.println(-1);
        }else{
            System.out.println(max_se-max);
        }





    }

    public static void dijk(int now){
        for(int i=0; i<arr[now].size(); i++){
            Node next = arr[now].get(i);
            if(dist[now]+next.time < dist[next.to]){
                dist[next.to] = dist[now]+next.time;
                path[next.to] = now;
                dijk(next.to);
            }
        }
    }

    public static int dijk_se(){
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>();
        int to =n;
        int from = path[n];

        while(true){
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1]=0;
            q.add(new Node(1,0));
            while(!q.isEmpty()){
                Node tmp = q.poll();
                for(int i=0; i<arr[tmp.to].size(); i++){
                    Node next = arr[tmp.to].get(i);
                    if(from != tmp.to || to!= next.to) {
                        if (dist[tmp.to] + next.time < dist[next.to]) {
                            dist[next.to] = dist[tmp.to] + next.time;
                            q.add(new Node(next.to, next.time));
                        }
                    }
                }
            }
            ans = Math.max(ans,dist[n]);
            if(from==1){
                break;
            }
            to = from;
            from = path[to];
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;

    }
}
class Node implements Comparable<Node>{
    int to,time;
    Node(int to, int time){
        this.to =to;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time-o.time;
    }
}