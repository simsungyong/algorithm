package back11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem11724 {

    static int n;
    static int line;
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        ArrayList<Integer> arr[] = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[s].add(m);
            arr[m].add(s);
        }
        for(int i=1; i<=n; i++){
            if(!visit[i]){
                count++;
                dfs(arr, i);
            }
        }

        System.out.print(count);

    }
    public static void dfs(ArrayList<Integer> arr[], int i){
        visit[i] = true;
        for(int k=0; k<arr[i].size(); k++){
            if(!visit[arr[i].get(k)]){
                dfs(arr, arr[i].get(k));
            }
        }
    }
}
//        for(int i=0; i<=n; i++){
//            arr[i] = new ArrayList<Integer>();
//        }
//
//        for(int i=0; i<line; i++){
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            arr[s].add(e);
//            arr[e].add(s);
//        }
//
//        for(int i=0; i<=n; i++){
//            Collections.sort(arr[i]);
//        }
//
//        for(int i=1; i<=n; i++){
//            if(!visit[i]){
//                count++;
//                dfs(arr, i);
//            }
//        }
//
//        System.out.println(count);
//
//    }
//
//    static public void dfs(ArrayList<Integer>[] arr, int i){
//        visit[i] = true;
//        for(int k=0; k<arr[i].size(); k++){
//            if(!visit[arr[i].get(k)]){
//                dfs(arr, arr[i].get(k));
//            }
//        }
//    }
//}
