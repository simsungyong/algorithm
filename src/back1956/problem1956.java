package back1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1956 {
    static int n,road;
    static ArrayList<City> arr[];
    static int minAnswer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<road; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[from].add(new City(to,cost));
        }
        for(int i=1; i<=n; i++){
            minAnswer = Math.min(minAnswer, dijkstra(i));
        }

        if(minAnswer !=Integer.MAX_VALUE){
            System.out.println(minAnswer);
        }else{
            System.out.println(-1);
        }

    }
    public static int dijkstra(int start){
        PriorityQueue<City> q = new PriorityQueue<>();
        int arr_dp[] = new int[n+1];
        Arrays.fill(arr_dp,Integer.MAX_VALUE);
        q.add(new City(start,0));
        arr_dp[start] = 0;
        boolean isCircle = false;

        while(!q.isEmpty()){
            City tmp = q.poll();
            for(int i= 0 ; i<arr[tmp.to].size(); i++){
                int nextCity = arr[tmp.to].get(i).to;
                int nextCost = arr[tmp.to].get(i).cost;
                if(nextCity==start){
                    int circle = nextCost+tmp.cost;
                    if(!isCircle){
                        isCircle = true;
                        arr_dp[start] = circle;
                    }else{
                        arr_dp[start] = Math.min(circle,arr_dp[start]);
                    }


                }else if(arr_dp[nextCity] > tmp.cost+nextCost){
                    arr_dp[nextCity]= tmp.cost+nextCost;
                    q.add(new City(nextCity,arr_dp[nextCity]));
                }
            }
        }



        return arr_dp[start] != 0 ? arr_dp[start] : Integer.MAX_VALUE;

    }
}

class City implements Comparable<City>{
    int to;
    int cost;
    City(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        return this.cost-o.cost;
    }
}