package back11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Node list []= new Node[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[i] = new Node(s,e);
        }

        Arrays.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.start==o2.start){
                    return Integer.compare(o1.end, o2.end);
                }else{
                    return Integer.compare(o1.start,o2.start);
                }
            }
        });
        q.add(list[0].end);
        for(int i=1; i<n; i++){
            if(q.peek() <= list[i].start){
                q.poll();
            }
            q.add(list[i].end);
        }

        System.out.println(q.size());

    }
}
class Node {
    int start, end;

    Node(int start, int end) {
        this.start = start;
        this.end = end;

    }
}
//
//    @Override
//    public int compare(Node o1, Node o2) {
//        if(o1.start==o2.start){
//            return Integer.compare(o1.end, o2.end);
//        }else{
//            return Integer.compare(o1.start,o2.start);
//        }
//    }
//}