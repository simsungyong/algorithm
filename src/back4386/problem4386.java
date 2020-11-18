package back4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem4386 {
    static int parents[];
    static Point point[];
    static PriorityQueue<Edge> edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double answer=0;
        int n = Integer.parseInt(br.readLine());
        parents = new int[n];
        edge = new PriorityQueue<>();
        point = new Point[n];
        for(int i=0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            point[i] = new Point(i,a,b);
            parents[i] =i;
        }


        for(int i=0;i<n-1; i++){
            for(int k=i+1; k<n; k++){
                double w = calWeight(point[i], point[k]);
                edge.add(new Edge(i,k,w));
            }
        }

        while(!edge.isEmpty()){
            Edge cnt = edge.poll();
            if(find(cnt.start) != find(cnt.end)){
                union(cnt.start, cnt.end);
                answer+=cnt.w;
            }
        }

        System.out.println(answer);




    }

    public static int find(int index){
        if(index == parents[index]){
            return index;
        }else{
            return parents[index] = find(parents[index]);
        }
    }

    public static void union(int a, int b){
        a= find(a);
        b = find(b);
        if(a == b){
            return;
        }else{
            if(a>b){
                parents[b] = a;
            }else{
                parents[a] = b;
            }
        }
    }


    public static double calWeight(Point a, Point b){
        return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y,2));
    }
}
class Point{
    int num;
    double x, y;
    Point(int num, double x, double y){
        this.num = num;
        this.x=x;
        this.y=y;
    }
}

class Edge implements Comparable<Edge>{
    int start,end;
    double w;
    Edge(int start, int end, double w ){
        this.start = start;
        this.end = end;
        this.w =w;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.w < o.w){
            return -1;
        }else{
            return 1;
        }
    }
}
