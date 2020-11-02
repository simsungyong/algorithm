package back1197;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1197 {
    static int n, line;
    static int parents[];
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>();
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.add(new Node(s, e, v));
        }
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (find(tmp.s) == find(tmp.e)) {
                continue;
            }

            union(tmp.s, tmp.e);
            sum += tmp.v;

        }

        System.out.println(sum);

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


class Node implements Comparable<Node>{
    int s,e,v;
    Node(int s, int e, int v){
        this.s =s;
        this.v=v;
        this.e =e;
    }

    @Override
    public int compareTo(Node o) {
        return this.v-o.v;
    }
}
