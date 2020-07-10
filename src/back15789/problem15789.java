package back15789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem15789 {
    static int n, relation;
    static ArrayList<Integer> arr[];
    static boolean check[];
    static int ctp,c,k;
    static PriorityQueue<node> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        relation = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        queue = new PriorityQueue<>();
        Arrays.fill(check,true);
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList();
        }

        for(int i=0; i<relation; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        ctp = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        checkC(c);
        int cntPow = checkCtp(ctp);


        for(int i=1; i<=n; i++){
            if(check[i]){
                search(i);
            }
        }

        int num=0;
        while(num<k && !queue.isEmpty()){
            cntPow += queue.poll().p;
            num++;
        }
        System.out.println(cntPow);


    }

    public static void checkC(int c){
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        while(!q.isEmpty()){
            int cnt = q.poll();
            check[cnt] = false;
            for(int i=0; i<arr[cnt].size(); i++){
                int next = arr[cnt].get(i);
                if(check[next]){
                    q.add(next);
                }
            }
        }
    }

    public static int checkCtp(int ctp){
        Queue<Integer> q = new LinkedList<>();
        int pow=0;
        q.add(ctp);
        while(!q.isEmpty()){
            int cnt = q.poll();
            pow++;
            check[cnt] = false;
            for(int i=0; i<arr[cnt].size(); i++){
                int next = arr[cnt].get(i);
                if(check[next]){
                    q.add(next);
                }
            }
        }
        return pow;
    }

    public static void search(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = false;
        int pow=1;
        while(!q.isEmpty()){
            int cnt = q.poll();

            for(int i=0; i<arr[cnt].size(); i++){
                int next = arr[cnt].get(i);
                if(check[next]){
                    q.add(next);
                    check[next] = false;
                    pow++;
                }
            }
        }
        queue.add(new node(pow));

    }
}
class node implements Comparable<node>{
    int p;
    node(int p){
        this.p = p;
    }
    @Override
    public int compareTo(node o) {
        return o.p-this.p;
    }
}
