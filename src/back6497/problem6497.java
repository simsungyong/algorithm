package back6497;

import programmers_disk.Prior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem6497 {
    static ArrayList<Node> arr[];
    static int parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Node> q;
        int answer;
        int total;
        int n;
        int line;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            if(n ==0 && line==0){
                break;
            }

            q = new PriorityQueue<>();
            answer=0;
            total=0;

            parents = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
            }

            for(int i=0; i<line; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                total+=v;
                q.add(new Node(s,e,v));
            }

            while(!q.isEmpty()){
                Node tmp = q.poll();
                if(find(tmp.start) != find(tmp.end )){
                    union(tmp.start,tmp.end);
                    answer+=tmp.v;
                }
            }

            sb.append(total-answer+"\n");

        }

        System.out.println(sb.toString());


    }

    public static int find(int index){
        if(index == parents[index]){
            return index;
        }else{
            return parents[index] = find(parents[index]);
        }
    }

    public static void union(int a, int b){
        a= find(a);
        b = find(b);
        if(a == b){
            return;
        }else{
            if(a>b){
                parents[b] = a;
            }else{
                parents[a] = b;
            }
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