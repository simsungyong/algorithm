package back2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem2644 {
    static int a,b,n,k;
    static boolean check[];
    static int answer = -1;
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int tm1 = Integer.parseInt(st.nextToken());
            int tm2 = Integer.parseInt(st.nextToken());
            arr[tm1].add(tm2);
            arr[tm2].add(tm1);
        }

        check[a] = true;
        dfs(a,0);

        System.out.print(answer);
    }

    public static void dfs(int x, int num){
        if(x==b){
            answer = num;
        }

        for(int i=0; i<arr[x].size(); i++){
            if(!check[arr[x].get(i)]){
                check[arr[x].get(i)] = true;
                dfs(arr[x].get(i), num+1);
            }
        }
    }
}
