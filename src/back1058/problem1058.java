package back1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class problem1058 {
    static ArrayList<Integer>[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }


        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            for (int k = 0; k < tmp.length(); k++) {
                if (tmp.charAt(k) == 'Y') {
                    arr[i].add(k);
                }
            }
        }
        int max = 0;
        //bfs(0);
        for(int i=0; i<n; i++){
            max = Math.max(bfs(i), max);
        }
        System.out.println(max);
    }

    public static int bfs(int start){
        int num=0;
        boolean check [] =new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        for(int i=0; i<arr[start].size(); i++){
            q.add(arr[start].get(i));
            check[arr[start].get(i)] = true;
        }



        while(!q.isEmpty()){
            int tmp = q.poll();
            num++;

            for(int i=0; i<n; i++){
                if(!check[i]){
                    for (int k = 0; k < arr[i].size(); k++) {
                        if(tmp == arr[i].get(k) && check[i]==false){
                            check[i] = true;
                            num++;
                        }
                    }

                }


            }
        }
        return num;
    }

}
