package back9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9466 {
    static int n,answer;
    static boolean visited[];
    static boolean finished[];
    static int arr[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            finished = new boolean[n+1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }

            for (int k = 1; k <= n; k++) {
                if (!visited[k]) {
                    dfs(k);
                }
            }
            sb.append(n-answer + "\n");
        }
        System.out.print(sb.toString());

    }
    public static void dfs(int now) {
        if(visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        if(visited[next] != true)
            dfs(next);
        else {
            if(finished[next] != true) {

                answer++;
                for(int i=next; i != now; i = arr[i])
                    answer++;
            }
        }

        finished[now] = true;
    }
}
