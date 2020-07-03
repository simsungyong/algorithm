package back1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1655 {
    static PriorityQueue<Node> qMax = new PriorityQueue();
    static PriorityQueue<Node> qMin = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());

            print(value);
        }
    }

    public static void print(int value){

        if((qMax.size()+1+qMin.size())%2==0){
            if(qMin.peek().v > value) {
                qMax.add(new Node(qMin.poll().v));
                qMin.add(new Node(value));
            }else{
                qMax.add(new Node(value));
            }
        }else{
            qMax.add(new Node(value));
            qMin.add(new Node(qMax.poll().v));
        }

        System.out.println(qMin.peek().v);
    }
}

class Node implements Comparable<Node>{
    int v;
    Node(int v){
        this.v =v;
    }
    @Override
    public int compareTo(Node o) {

        return this.v-o.v;
    }
}
