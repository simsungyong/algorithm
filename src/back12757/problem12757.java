package back12757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem12757 {
    static int k;
    static HashMap<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            if(type==3){
                int t = find(key);
                if(t==-1){
                    sb.append("?\n");
                }else if(t==-2){
                    sb.append("-1\n");
                }else{
                    sb.append(map.get(t)+"\n");
                }
            }else if(type==1){
                int v = Integer.parseInt(st.nextToken());
                map.put(key,v);
            }else{
                int v = Integer.parseInt(st.nextToken());
                int t = find(key);
                if(t!=-1 && t!=-2){
                    map.replace(t,v);
                }
            }

        }
        System.out.println(sb.toString());
    }

    public static int find(int n){
        for(int i=0; i<=k; i++){
            if(map.containsKey(n+i) || map.containsKey(n-i)){
                if(map.containsKey(n+i) && map.containsKey(n-i)){
                    return -1;
                }else{
                    if(map.containsKey(n+i)){
                        return n+i;
                    }else{
                        return n-i;
                    }
                }
            }
        }
        return -2;
    }
}
