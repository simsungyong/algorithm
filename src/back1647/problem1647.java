package back1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1647 {
    static int n,line;
    static boolean check[];
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int answer = 0;
        StringTokenizer st;
        PriorityQueue<Node> q = new PriorityQueue<>();
        Queue<Integer> vertex = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        ArrayList<Node> list[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Node(s,e,v));
            list[e].add(new Node(e,s,v));
        }

        vertex.add(1);
        check[1] = true;

        while(!vertex.isEmpty()){
            int tmp = vertex.poll();
            for(int i=0; i<list[tmp].size(); i++){
                if(!check[list[tmp].get(i).end]){
                    q.add(list[tmp].get(i));
                }
            }

            while(!q.isEmpty()){
                Node cnt = q.poll();
                if(!check[cnt.end]){
                    check[cnt.end]  = true;
                    max = Math.max(max, cnt.v);
                    answer += cnt.v;
                    vertex.add(cnt.end);
                    break;
                }
            }


        }

        System.out.println(answer-max);






    }

//    public static int find(int index){
//
//        if(index==parents[index]){
//            return index;
//        }else{
//            return parents[index] = find(parents[index]);
//        }
//    }
//
//    public static void union(int a, int b){
//        a = find(a);
//        b = find(b);
//        if(a==b){
//            return;
//        }else{
//            parents[a] =b;
//        }
//    }
}

class Node implements Comparable<Node>{
    int start,end,v;
    Node(int start, int end, int v){
        this.start =start;
        this.end = end;
        this.v=v;
    }
    @Override
    public int compareTo(Node o) {
        if(this.v < o.v){
            return -1;
        }else{
            return 1;
        }
    }
}
