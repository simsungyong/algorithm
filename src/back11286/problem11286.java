package back11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Big> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n; i++){
            int cnt = Integer.parseInt(br.readLine());

            if(cnt==0){
                if(!q.isEmpty()){
                    System.out.println(q.poll().x);
                }else{
                    System.out.println(0);
                }
            }else{
                q.add(new Big(cnt));
            }

        }



    }
}
class Big implements Comparable<Big>{
    int x;
    Big(int x){
        this.x = x;
    }
    @Override
    public int compareTo(Big o) {
        if(Math.abs(this.x)<Math.abs(o.x)){
            return -2;
        }else if(Math.abs(this.x)==Math.abs(o.x)){
            if(this.x < o.x){
                return -1;
            }else{
                return 1;
            }
        }else{
            return 2;
        }
    }
}
