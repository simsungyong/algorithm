package back1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1068 {
    static int n;
    static boolean check[];
    static ArrayList<Integer> arr[];
    static int input[];
    static int childN[];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n];
        arr = new ArrayList[n];
        childN = new int[n];
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){

            check[i]  = true;
            int temp = Integer.parseInt(st.nextToken());

            if(temp!=-1){
                arr[temp].add(i);
                input[i] = temp;
                childN[temp]++;
            }
        }
        dfs(Integer.parseInt(br.readLine()));

        while(!q.isEmpty()){
            int temp = q.poll();
            check[temp] = false;
            childN[input[temp]]--;
        }



        int answer=0;
        for(int i=0; i<n; i++){
            if(childN[i]==0 && check[i]){
                answer++;
            }
        }
        System.out.print(answer);

    }

    public static void dfs(int node){
        q.add(node);
        for(int i=0; i<arr[node].size(); i++){
            dfs(arr[node].get(i));
        }
    }
}
