package 네트워크;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class problem {
    static boolean check[];
    static ArrayList<Integer> arr[];
    public static void main(String[] args) {
        int n=3;
        int [][] a = {{1,1,0},{1,1,1},{0,1,1}};

        System.out.print(solution(n,a));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(computers[i][k]==1){
                    arr[i].add(k);
                }
            }
        }


        for(int i=0; i<n; i++){
            if(!check[i]){
                bfs(i);
                answer++;
            }
        }


        return answer;
    }

    public static void bfs(int cnt){
        Queue<Integer> q = new LinkedList<>();
        q.add(cnt);
        check[cnt] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<arr[temp].size(); i++ ){
                if(!check[arr[temp].get(i)]){
                    check[arr[temp].get(i)] = true;
                    q.add(arr[temp].get(i));
                }
            }
        }
    }
}
