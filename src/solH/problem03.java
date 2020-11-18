package solH;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class problem03 {
    public static void main(String[] args) {
        int path[][]= {{1,2,2,3},{2,7,3,3}, {1,3,4,1},{7,6,2,4},{6,5,2,3},{5,7,2,1},{3,6,4,2},{5,4,3,2},{3,4,1,1}};
        System.out.println(solution(7,5, path));
    }
    public static int[] solution(int n,int k, int path[][]){
        int answer[]= new int[2];
        ArrayList<NodeAir> list[] =new ArrayList[n+1];
        int timelist[] = new int[n+1];
        int pointlist[] = new int[n+1];

        for(int i=1; i<=n; i++){
            timelist[i] = Integer.MAX_VALUE;
            pointlist[i] = Integer.MIN_VALUE;
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<path.length;i ++){
            int a = path[i][0];
            int b = path[i][1];

            list[a].add(new NodeAir(b,path[i][2],path[i][3]));
            list[b].add(new NodeAir(a,path[i][2],path[i][3]));
        }



        dijkstra(timelist,pointlist,list);

        for(int i=1; i<=n;i++){
            System.out.println(timelist[i]+" "+pointlist[i]);
        }

        answer[0] = timelist[k];
        answer[1] = pointlist[k];
        return answer;
    }
    public static void dijkstra(int timelist[], int pointlist[], ArrayList<NodeAir> list[]){
        PriorityQueue<NodeAir> q = new PriorityQueue<>();

        timelist[1] = 0;
        pointlist[1]=0;
        q.add(new NodeAir(1,0,0));
        while(!q.isEmpty()){

            NodeAir tmp = q.poll();
            for(int i=0; i<list[tmp.to].size(); i++){
                NodeAir next = list[tmp.to].get(i);
                if(timelist[next.to] > timelist[tmp.to] + next.time){
                    timelist[next.to] = timelist[tmp.to] + next.time;
                    pointlist[next.to] = pointlist[tmp.to]+next.point;
                    q.add(new NodeAir(next.to, timelist[next.to], pointlist[next.to]));
                }else if(timelist[next.to] == (timelist[tmp.to] + next.time)){
                    if(pointlist[next.to] < pointlist[tmp.to]+next.point){
                        pointlist[next.to] = pointlist[tmp.to]+next.point;
                        q.add(new NodeAir(next.to, timelist[next.to], pointlist[next.to]));
                    }
                }
            }
        }
    }
}

class NodeAir implements Comparable<NodeAir>{
    int to, time, point;
    NodeAir(int to, int time, int point) {
        this.to = to;
        this.time = time;
        this.point = point;
    }

    @Override
    public int compareTo(NodeAir o) {
        return this.time-o.time;
    }
}
