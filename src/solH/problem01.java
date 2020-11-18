package solH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class problem01 {
    public static void main(String[] args) {
        int fees[][]= {{1,2,1000},{1,5,2000}, {2,3,3000},{2,4,1500},{3,4,1000},{4,5,2000}};
        System.out.println(solution(5,fees,3));
    }
    public static int solution(int N, int fees[][], int dest){
        ArrayList<Node> list[] =new ArrayList[N+1];
        int value[] = new int[N+1];
        Arrays.fill(value,Integer.MAX_VALUE);
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<fees.length;i ++){
            int a = fees[i][0];
            int b = fees[i][1];
            int cost = fees[i][2];
            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));
        }

        dijkstra(value,list);

        return value[dest];
    }
    public static void dijkstra(int value[], ArrayList<Node> list[]){
        PriorityQueue<Node> q = new PriorityQueue<>();

        value[1] = 0;
        q.add(new Node(1,0));
        while(!q.isEmpty()){

            Node tmp = q.poll();
            System.out.println(tmp.to);
            for(int i=0; i<list[tmp.to].size(); i++){
                Node next = list[tmp.to].get(i);
                if(value[next.to] > value[tmp.to] + next.c){
                    value[next.to] = value[tmp.to] + next.c;
                    q.add(new Node(next.to, value[next.to]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int to, c;
    Node(int to, int c){
        this.to = to;
        this.c =c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}
