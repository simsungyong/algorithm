package back1197;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1197 {
    static ArrayList<Node> arr[];
    static boolean check[][];
    static int arrmin[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int num =0;
        int n = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        check = new boolean[n][n];
        arrmin = new int[n][n];


        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (num != n-1) {
            int temp = q.poll();
            for (int i = 0; i < arr[temp].size(); i++) {
                int next = arr[temp].get(i).to;
                int v = arr[temp].get(i).v;
                if (!check[temp][next]) {
                    arrmin[temp][next] = v;
                    arrmin[next][temp] = v;
                    check[temp][next] = true;
                    check[next][temp] = true;
                    num++;
                    answer+=v;
                    q.add(next);


                } else {
                    if (arrmin[temp][next] > v || arrmin[next][temp] > v) {
                        answer = answer - arrmin[temp][next]+v;
                        arrmin[temp][next] = v;
                        arrmin[next][temp] = v;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(answer);

    }
}


class Node {
    int to,v;
    Node(int to, int v){
        this.to =to;
        this.v=v;
    }
}
