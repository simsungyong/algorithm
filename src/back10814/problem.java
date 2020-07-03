package back10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Priorq> q = new PriorityQueue<>();
        List<Priorq> l = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            q.add(new Priorq(i,age,name));

        }
        for (int i = 0; i < n; i++) {
            l.add(q.poll());
        }

        for (int i = 0; i < n; i++) {
            System.out.print(l.get(i).age+" ");
            System.out.println(l.get(i).name);

        }
    }
}


class Priorq implements Comparable<Priorq>{
    int num;
    int age;
    String name;
    public Priorq(int num, int age, String name){
        this.age = age;
        this.num = num;
        this.name = name;
    }
    @Override
    public int compareTo(Priorq o) {
        if(this.age < o.age){
            return -1;
        }else if(this.age == o.age){
            return this.num < o.num ? -1 : 1;
        }else{
            return 1;
        }

    }
}

//순서신경쓸때 priorityqueue에 순서 파라미터 하나 추가