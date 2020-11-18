package back2887;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2887 {
    static int parents[];
    static Point point[];
    static PriorityQueue<Edge> edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer=0;
        int n = Integer.parseInt(br.readLine());
        parents = new int[n];
        edge = new PriorityQueue<>();
        point = new Point[n];
        for(int i=0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            point[i] = new Point(i,a,b,c);
            parents[i] =i;
        }

        Arrays.sort(point, (a,b)->a.x-b.x);

        for(int i=0;i<n-1; i++){
            int w = Math.abs(point[i].x - point[i+1].x);
            edge.add(new Edge(point[i].num, point[i+1].num,w));
        }

        Arrays.sort(point, (a,b)->a.y-b.y);

        for(int i=0;i<n-1; i++){
            int w = Math.abs(point[i].y-point[i+1].y);
            edge.add(new Edge(point[i].num, point[i+1].num,w));
        }

        Arrays.sort(point, (a,b)->a.z-b.z);

        for(int i=0;i<n-1; i++){
            int w = Math.abs(point[i].z-point[i+1].z);
            edge.add(new Edge(point[i].num, point[i+1].num,w));
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


    public static int calWeight(Point a, Point b){
        return Math.min(Math.abs(a.x-b.x), Math.min(Math.abs(a.y-b.y), Math.abs(a.z-b.z)));
    }
}
class Point{
    int num;
    int x, y, z;
    Point(int num, int x, int y, int z){
        this.num = num;
        this.x=x;
        this.y=y;
        this.z=z;
    }
}

class Edge implements Comparable<Edge>{
    int start,end;
    int w;
    Edge(int start, int end, int w ){
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
