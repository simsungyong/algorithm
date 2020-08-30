package back1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem1238 {
    static int n,line,goal;
    static ArrayList<Node> arr[];
    static ArrayList<Node> arr_reverse[];
    static int dist[];
    static int re_dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        arr_reverse = new ArrayList[n+1];
        dist = new int[n+1];
        re_dist = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            arr_reverse[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            re_dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,t));
            arr_reverse[b].add(new Node(a,t));
        }
        dist[goal] = 0;
        dfs(goal);

        re_dist[goal] = 0;
        re_dfs(goal);
        int answer=Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            answer = answer > dist[i]+re_dist[i] ? answer : dist[i]+re_dist[i];
        }

        System.out.println(answer);





    }
    public static void dfs(int x){
        for(int i=0; i<arr[x].size(); i++){
            int next = arr[x].get(i).to;
            if(dist[next] > dist[x]+arr[x].get(i).time){
                dist[next] = dist[x]+arr[x].get(i).time;
                dfs(next);
            }

        }
    }
    public static void re_dfs(int x){
        for(int i=0; i<arr_reverse[x].size(); i++){
            int next = arr_reverse[x].get(i).to;

            if(re_dist[next] > re_dist[x]+arr_reverse[x].get(i).time){
                re_dist[next] = re_dist[x]+arr_reverse[x].get(i).time;
                re_dfs(next);
            }

        }
    }

}

class Node{
    int to, time;
    Node(int to, int time){
        this.to =to;
        this.time= time;
    }
}
