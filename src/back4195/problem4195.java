package back4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.StringTokenizer;

public class problem4195 {
    static int parentnode[];
    static int groupnum[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map;

        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            int n = Integer.parseInt(br.readLine());
            int index=0;
            parentnode = new int[n*2];
            groupnum = new int[n*2];
            map = new HashMap<>();
            for(int k=0; k<n; k++){
                st = new StringTokenizer(br.readLine());
                String temp[] = {st.nextToken(),st.nextToken()};
                for(int j=0; j<2; j++){
                    if(!map.containsKey(temp[j])){
                        parentnode[index] = index;
                        groupnum[index] = 1;
                        map.put(temp[j],index++);
                    }
                }
                int v = union(map.get(temp[0]), map.get(temp[1]));

                sb.append(v+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int find(int a){
        if(a==parentnode[a]){
            return a;
        }else{
            return parentnode[a] = find(parentnode[a]);
        }
    }

    public static int union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return groupnum[a];

        if(a>b){
            parentnode[a] = b;
            groupnum[b] += groupnum[a];
            return groupnum[b];
        }else{
            parentnode[b] = a;
            groupnum[a] += groupnum[b];
            return groupnum[a];
        }
    }
}
