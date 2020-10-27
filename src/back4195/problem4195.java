package back4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class problem4195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        Set<String> set;
        for(int i=0; i<testcase; i++){
            set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            for(int k=0; k<n; k++){
                boolean check = false;
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<2; j++){
                    String name  = st.nextToken();
                    if(set.contains(name)){
                        check = true;
                    }else{
                        set.add(name);
                    }
                }

                sb.append(set.size()+"\n");

            }
        }
        System.out.println(sb.toString());
    }
}
