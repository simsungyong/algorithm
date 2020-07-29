package testest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem111 {
    static int five_pin;
    static int e_pin;
    static int both_pin;
    static long answer=0;
    static int num=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> q= new PriorityQueue<>();
        five_pin = Integer.parseInt(st.nextToken());
        e_pin = Integer.parseInt(st.nextToken());
        both_pin = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int kind = Integer.parseInt(st.nextToken());
            q.add(new Node(cost,kind));
        }





        for(int i=0; i<n; i++){
            Node cnt = q.poll();
            if(cnt.kind==0){
                if(five_pin>0){
                    answer+=cnt.x;
                    num++;
                    five_pin = five_pin-1;
                }else{
                    if(both_pin>0){
                        answer+=cnt.x;
                        num++;
                        both_pin = both_pin-1;
                    }
                }
            }else if(cnt.kind==1){
                if(e_pin>0){
                    answer+=cnt.x;
                    num++;
                    e_pin = e_pin-1;
                }else{
                    if(both_pin>0){
                        answer+=cnt.x;
                        num++;
                        both_pin = both_pin-1;
                    }
                }
            }
        }

        System.out.print(num+" "+answer);





    }
}

class Node implements Comparable<Node>{
    int x;
    int kind;
    Node(int x, int kind){
        this.x=x;
        this.kind= kind;
    }
    @Override
    public int compareTo(Node o) {
        return this.x-o.x;
    }
}
