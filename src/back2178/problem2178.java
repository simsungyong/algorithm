package back2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class problem2178 {
    static int moveX[] = {0, 1, -1, 0};
    static int moveY[] = {-1, 0, 0, 1};
    static int input[][];
    static int map[][];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cnt = st.nextToken();
            for (int k = 0; k < m; k++) {
                input[i][k] = (int) cnt.charAt(k) - '0';
                map[i][k] = Integer.MAX_VALUE;
            }
        }

        bfs();


        System.out.println(map[n - 1][m - 1]);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        map[0][0] = 1;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = tmp.x + moveX[i];
                int newY = tmp.y + moveY[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && input[newX][newY] == 1) {
                    if (map[newX][newY] > map[tmp.x][tmp.y] + 1) {
                        map[newX][newY] = map[tmp.x][tmp.y] + 1;
                        q.add(new Node(newX, newY));
                    }
                }
            }
        }
    }
}


class Node {
    int x,y;
    Node(int x, int y){
        this.x =x;
        this.y=y;
    }
}

//dfs로하면 시간초과남

