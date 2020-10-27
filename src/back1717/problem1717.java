package back1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem1717 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i]=i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type==0){
                union(a,b);
            }else{
                if(isSameparent(a,b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }

        }

        System.out.println(sb.toString());
    }

    public static int find(int v){
        if(arr[v]==v){
            return v;
        }else{
            return arr[v] = find(arr[v]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a>b){
                arr[a] = b;
            }else{
                arr[b] =a;
            }
        }
    }


    public static boolean isSameparent(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b){
            return true;
        }else{
            return false;
        }
    }




}
