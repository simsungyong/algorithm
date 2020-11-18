package back11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            q.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(!q.isEmpty()){
            Node tmp = q.poll();
            System.out.println(tmp.x+" "+tmp.y);
        }

    }
}
class Node implements Comparable<Node>{
    int x, y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Node o) {
        if(this.y > o.y){
            return 1;
        }else if(this.y==o.y){
            if(this.x > o.x){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
