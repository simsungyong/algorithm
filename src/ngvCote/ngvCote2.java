package ngvCote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ngvCote2 {

    static int[] CNT;
    static List<Integer>[] GRAPH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        CNT = new int[n + 1];
        GRAPH = new ArrayList[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (GRAPH[p] == null) {
                GRAPH[p] = new ArrayList<>();
            }
            GRAPH[p].add(i);
        }
        dfs(0);
        long answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            answer += Math.abs(CNT[a] - CNT[b]);
        }

        System.out.println(answer);

    }

    static int dfs(int here) {
        if (GRAPH[here] == null) {
            return 0;
        }
        for (int next : GRAPH[here]) {
            CNT[here] += dfs(next) + 1;
        }
        return CNT[here];
    }
}