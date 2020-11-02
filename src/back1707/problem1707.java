package back1707;

import programmers_disk.Prior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1707 {
    static int parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int line,n;
        Queue<Node> q;

        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            boolean check = true;
            parents = new int[n+1];
            q = new LinkedList<>();

            for(int k=1; k<=n; k++){
                parents[k]=k;
            }

            for (int k = 0; k < line; k++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                q.add(new Node(s, e));
            }

            while (!q.isEmpty()) {
                Node tmp = q.poll();
                if (find(tmp.s) == find(tmp.e)) {
                    check = false;
                    break;
                }
                union(tmp.s, tmp.e);
            }

            if(check){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int find(int index) {

        if (index == parents[index]) {
            return index;
        } else {
            return parents[index] = find(parents[index]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        } else {
            parents[a] = b;
        }
    }
}

class Node {
    int s,e;
    Node(int s, int e){
        this.s =s;
        this.e =e;
    }
}

