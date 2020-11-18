package back3176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem3176 {
    static int n;
    static ArrayList<Node> input[];
    static int min,max;
    static int from,end;
    static boolean check[];
    static int val[];
    static int parents[];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        input = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            input[i] = new ArrayList<>();
        }

        for(int i= 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            input[a].add(new Node(a,b,c));
            input[b].add(new Node(b,a,c));
        }

        int casen = Integer.parseInt(br.readLine());
        for(int i=0;i<casen; i++){
            check = new boolean[n+1];
            val = new int [n+1];
            parents = new int[n+1];
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            bfs(from,end);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int cnt = end;


            while(true){
                if(cnt==from){
                    break;
                }

                max = Math.max(max,val[cnt]);
                min = Math.min(min,val[cnt]);

                cnt = parents[cnt];
            }

            sb.append(min+" "+max+"\n");



        }
        System.out.println(sb.toString());

    }

    public static void bfs(int node, int end){
        Queue<Integer> q = new LinkedList<>();
        check[node] = true;
        q.add(node);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp == end){
                break;
            }

            for(int i=0; i<input[temp].size(); i++){
                Node next = input[temp].get(i);
                if(check[next.to]) continue;
                check[next.to] = true;
                parents[next.to] = temp;
                val[next.to] = next.value;
                q.add(next.to);

            }
        }
    }
}

class Node {
    int from,to,value;
    Node(int from, int to, int value){
        this.from = from;
        this.to=to;
        this.value = value;
    }
}
