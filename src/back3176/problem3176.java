package back3176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem3176 {
    static int n;
    static ArrayList<Node> input[];
    static int min,max;
    static int from,end;
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
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dfs(from);
            sb.append(min+" "+max+"\n");
        }
        System.out.println(sb.toString());

    }

    public static void dfs(int node){
        if(node==end){
            return;
        }

        for(int i=0; i<input[node].size(); i++){
            int next = input[node].get(i).to;
            if(next != node){

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
