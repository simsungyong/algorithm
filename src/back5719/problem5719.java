package back5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem5719 {
    static int N, M, start, end;
    static ArrayList<Node> list[];
    static ArrayList<Integer> route[];
    static int distance[];
    static int check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            list = new ArrayList[N];
            distance = new int[N];
            check = new int[N];
            route = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                route[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to, cost));
            }

            dijkstraFirst(start);

            remove();

            dijkstraFirst(start);



            if(distance[end]<Integer.MAX_VALUE){
                System.out.println(distance[end]);

            }else{
                System.out.println(-1);
            }




        }

    }

    public static void dijkstraFirst(int start) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int cnt = q.poll();
            for (int i = 0; i < list[cnt].size(); i++) {
                if (distance[list[cnt].get(i).to] > distance[cnt] + list[cnt].get(i).cost) {
                    distance[list[cnt].get(i).to] = distance[cnt] + list[cnt].get(i).cost;
                    route[list[cnt].get(i).to].clear();
                    route[list[cnt].get(i).to].add(cnt);
                    q.add(list[cnt].get(i).to);
                } else if (distance[list[cnt].get(i).to] == distance[cnt] + list[cnt].get(i).cost) {
                    route[list[cnt].get(i).to].add(cnt);
                }
            }
        }
    }

    public static void remove(){
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i< route[end].size(); i++){
            q.add(new Node(route[end].get(i),end));
        }

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<list[tmp.to].size(); i++){
                if(list[tmp.to].get(i).to==tmp.cost){
                    list[tmp.to].remove(i);
                }
            }

            for(int i=0; i<route[tmp.to].size(); i++){
                q.add(new Node(route[tmp.to].get(i),tmp.to ));
            }
        }

    }
}
class Node {
    int to,cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}