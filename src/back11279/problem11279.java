package back11279;

import java.util.PriorityQueue;
import java.util.Scanner;

public class problem11279 {
    static PriorityQueue<Prior> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q = new PriorityQueue<>();
        int n =sc.nextInt();
        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();
            if(tmp==0){
                print();
            }else{
                q.add(new Prior(tmp));
            }
        }
    }

    public static void print(){

            if(q.size()==0){
                System.out.println(0);
            }else{
                System.out.println(q.poll().v);
            }

    }
}

class Prior implements Comparable<Prior>{
    int v;
    Prior(int v){
        this.v = v;
    }
    @Override
    public int compareTo(Prior o) {
        return o.v-this.v;
    }
}
