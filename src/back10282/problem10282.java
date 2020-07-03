package back10282;


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class problem10282 {
    static ArrayList<group> list[];
    static int dist[];
    static int n,d;
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];
            dist = new int[n+1];
            check = new boolean[n+1];
            for(int k=0; k<=n; k++){
                list[k] = new ArrayList<>();
            }
            for(int k=0; k<d; k++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[b].add(new group(a, cost));
            }

            dijkstra(start);

            int max = Integer.MIN_VALUE;
            int num=0;
            for(int k=1; k<=n; k++){
                if(check[k]){
                    num +=1;
                    if(max < dist[k]){
                        max = dist[k];
                    }
                }
            }



            System.out.println(num+" "+max);






        }
    }

    public static void dijkstra(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start]=0;
        while(!q.isEmpty()){
            int from = q.poll();
            check[from] = true;
            for(int i=0; i<list[from].size(); i++){
                if(dist[from]+list[from].get(i).time < dist[list[from].get(i).index]){
                    dist[list[from].get(i).index] = dist[from]+list[from].get(i).time;
                    q.add(list[from].get(i).index);
                }
            }
        }




    }
}


class group {
    int index;
    int time;
    group(int index, int time){
        this.index = index;
        this.time = time;
    }
}
