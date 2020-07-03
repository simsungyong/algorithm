package back6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem6118 {
    static int n,m;
    static ArrayList<Integer> []list;
    static int answer;
    static int max;
    static int num;
    static int indexSmall;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        answer=0;
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dijkstra(1);

        System.out.print(indexSmall+" "+max+" "+num);

    }

    public static void dijkstra(int p){
        int distance[] = new int[n+1];
        boolean check [] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(p);
        Arrays.fill(distance, Integer.MAX_VALUE);//다익스타라 초기 맥스로 채워준다.
        distance[1]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();



        while(!q.isEmpty()){
            int tmp = q.poll();
            check[tmp] = true;

            for(int i=0; i<list[tmp].size(); i++){
                int next = list[tmp].get(i);
                if(distance[next] > distance[tmp]+1 && !check[next]){
                    distance[next] = distance[tmp]+1;
                    q.add(next);
                }
            }
        }

        for(int i=1; i<=n; i++){
            pq.add(new Node(i,distance[i]));
        }
        Node no = pq.poll();
        max = no.distance;
        indexSmall= no.index;
        num=1;

        while(true){
            if(pq.peek().distance==max){
                num++;
                pq.poll();
            }else{
                break;
            }
        }



    }
}

class Node implements Comparable<Node>{
    int index, distance;
    Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance){
            return 2;
        }else if(this.distance==o.distance){
            if(this.index < o.index){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -2;
        }
    }
}
