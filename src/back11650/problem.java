package back11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem {
    public static void main(String[] args) throws IOException {
        PriorityQueue<prior> q = new PriorityQueue<>();
        List<prior> l = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.add(new prior(x,y));
        }
        for (int i = 0; i < n; i++) {
            l.add(q.poll());
        }

        for(int i=0; i< n; i++){
            System.out.println(l.get(i).x+" "+l.get(i).y);
        }

    }
}

class prior implements Comparable<prior>{
    int x;
    int y;
    public prior(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(prior o) {
        if(this.x < o.x){
            return -1;
        }else if(this.x == o.x){
           return this.y <= o.y ? -1 : 1;
        }else{
            return 1;
        } }
}

//정렬~ 우선순위가 음수일수록 높다.