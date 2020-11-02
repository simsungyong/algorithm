package back1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1922 {
    static int n,line;
    static int parents[];
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> q = new PriorityQueue<>();
        n  = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i] = i;
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.add(new Node(s,e,v));
        }

        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(find(tmp.start)==find(tmp.end)){
                continue;
            }

            union(tmp.start,tmp.end);
            sum+=tmp.v;

        }

        System.out.println(sum);






    }

    public static int find(int index){

        if(index==parents[index]){
            return index;
        }else{
            return parents[index] = find(parents[index]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return;
        }else{
            parents[a] =b;
        }
    }
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
