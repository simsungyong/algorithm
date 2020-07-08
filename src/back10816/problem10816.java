package back10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class problem10816 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(st.nextToken());
            if(map.containsKey(cnt)){
                map.replace(cnt,map.get(cnt)+1);
            }else{
                map.put(cnt,1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int cnt = Integer.parseInt(st.nextToken());
            if(map.containsKey(cnt)){
                sb.append(map.get(cnt)+" ");
            }else{
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
    }
}
