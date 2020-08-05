package back1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> q = new PriorityQueue<>();
        StringTokenizer st;
        int answer = 0;
        int beforeend = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            q.add(new Node(start,end));
        }

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.start >= beforeend){
                answer++;
                beforeend = temp.end;
            }
        }

        System.out.print(answer);





    }
}
class Node implements Comparable<Node>{
    int start;
    int end;
    Node(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Node o) {
        if(this.end > o.end){
            return 2;
        }else if(this.end==o.end){
            if(this.start > o.start){
                return 2;
            }else{
                return -2;
            }
        }else{
            return -2;
        }
    }
}