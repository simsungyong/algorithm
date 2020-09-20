package kakaoblind하반기.problem4;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class problem4 {

    static ArrayList<Node> arr[];
    static int dist[][];

    public static void main(String[] args) {
        int arr[][] = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        solution(6,4,6,2,arr);
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        dist = new int[3][n+1];
        arr = new ArrayList[n+1];
        for(int i=0;i<3;i++){
            for(int k=0; k<=n; k++){
                dist[i][k] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = s;
        dist[1][0] =a;
        dist[2][0] = b;

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int value = fares[i][2];
            arr[start].add(new Node(end,value));
            arr[end].add(new Node(start, value));
        }

        for(int i=0;i<3; i++){
            dijk(i, dist[i][0]);
        }

        int tempans;

        for(int i=1;i<=n;i++){
            tempans=0;
            for(int k=0; k<=2; k++){
                tempans+=dist[k][i];
            }
            answer = Math.min(tempans,answer);
        }



        return answer;
    }

    public static void dijk(int index, int goal){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(goal,0));
        dist[index][goal]=0;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<arr[tmp.to].size(); i++){
                Node next = arr[tmp.to].get(i);
                if(dist[index][tmp.to]+next.cost < dist[index][next.to]){
                    dist[index][next.to] = dist[index][tmp.to]+next.cost;
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