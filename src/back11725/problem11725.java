package back11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem11725 {
    static ArrayList<Integer> list [];
    static int head[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        head = new int [n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        tree();

        for(int i=2; i<=n; i++){
            System.out.println(head[i]);
        }



    }
    public static void tree(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        head[1] =1;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<list[tmp].size(); i++){
                if(head[list[tmp].get(i)]==0){
                    head[list[tmp].get(i)] = tmp;
                    q.add(list[tmp].get(i));
                }
            }
        }
    }
}
