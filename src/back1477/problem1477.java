package back1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>();
        int cnt = Integer.parseInt(st.nextToken());
        int plan = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int arr[]  = new int[cnt+2];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=cnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[cnt+1] = length;

        Arrays.sort(arr);

        for(int i=1; i<=cnt+1; i++){
            q.add(new Node(arr[i-1], arr[i]));
        }

        while(plan>0){
            Node tmp  = q.poll();
            int newpoint = (tmp.end+tmp.start)/2;
            q.add(new Node(tmp.start, newpoint));
            q.add(new Node(newpoint, tmp.end));
            plan--;
        }

        while (!q.isEmpty()){
            Node tmp = q.poll();
            System.out.println(tmp.start+" "+tmp.end+" "+(tmp.end-tmp.start));
        }

    }
}

class Node implements Comparable<Node>{
    int start, end;

    Node(int start, int end){
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Node o) {
        return  (o.end-o.start)-(this.end-this.start);
    }
}