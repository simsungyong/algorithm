package back2472;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2472 {
    static int N,A,B,C;
    static ArrayList<Node> arr[];
    static int dist[];
    static int value[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        dist = new int[N+1];
        value = new int[N+1][3];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        int line = Integer.parseInt(br.readLine());
        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,c));
            arr[e].add(new Node(s,c));
        }

        for(int i=1; i<=N; i++){
            dijk(i);
        }

        int Question = Integer.parseInt(br.readLine());
        for(int i=0; i<Question; i++){
            boolean isEnd = false;
            int tmp = Integer.parseInt(br.readLine());
            for(int k=1; k<=N; k++){
                if(k!=tmp){
                    if(value[tmp][0] > value[k][0] && value[tmp][1] > value[k][1] && value[tmp][2] > value[k][2]){
                        sb.append("NO"+"\n");
                        isEnd = true;
                        break;
                    }
                }
            }
            if(!isEnd){
                sb.append("YES"+"\n");
            }
        }

        System.out.println(sb.toString());

    }
    public static void dijk(int no){
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[no] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(no, 0));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<arr[tmp.to].size(); i++){
                Node next = arr[tmp.to].get(i);
                if(dist[next.to] > dist[tmp.to]+ next.cost){
                    dist[next.to] = dist[tmp.to]+ next.cost;
                    q.add(new Node(next.to,dist[next.to]));
                }
            }
        }

        value[no][0] = dist[A];
        value[no][1] = dist[B];
        value[no][2] = dist[C];


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
        return 0;
    }
}
//시간초과
