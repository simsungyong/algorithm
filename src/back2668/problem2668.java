package back2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem2668 {
    static int[] arr;
    static boolean[] visited;
    static int start;
    static ArrayList<Integer> list;
    //dfs재귀쓸려면 전역변수로 설정해놓자!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int [n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();
        //input 받기
        for(int i =1; i<=n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=n; i++){
            visited[i] = true;
            start = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i =0; i<list.size(); i++){
            System.out.println(list.get(i));
        }


    }
    public static void dfs(int i){
        if(!visited[arr[i]]){
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }else if(start == arr[i]){
            list.add(arr[i]);
        }
    }
}
