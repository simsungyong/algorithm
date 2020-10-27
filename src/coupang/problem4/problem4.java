package coupang.problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class problem4 {

    public static void main(String[] args) {
        String depar = "SEOUL";
        String hub = "DAEGU";
        String dest = "YEOSU";
        String roads[][]={{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};
        System.out.println(solution(depar,hub,dest,roads));
    }
    public static int solution(String depar, String hub, String dest, String [][] roads){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<roads.length; i++){
            String start = roads[i][0];
            String end = roads[i][1];
            if(!map.containsKey(start)){
                map.put(start, map.size());
            }

            if(!map.containsKey(end)){
                map.put(end, map.size());
            }
        }

        ArrayList<Integer> arr[] = new ArrayList[map.size()];
        for(int i=0; i<map.size(); i++){
            arr[i] = new ArrayList<>();
        }


        for(int i=0; i<roads.length; i++){
            int start = map.get(roads[i][0]);
            int end = map.get(roads[i][1]);
            arr[start].add(end);
        }

        int answer;
        int start = map.get(depar);
        int mid = map.get(hub);
        int end = map.get(dest);

        answer = bfs(start,mid, arr)*bfs(mid,end,arr);

        return answer;

    }

    public static int bfs(int s, int e, ArrayList<Integer> arr[]){
        int num=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp==e){
                num++;
            }
            for(int i=0; i<arr[temp].size(); i++){
                q.add(arr[temp].get(i));
            }
        }

        return num;
    }
}
