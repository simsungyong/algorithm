package back10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10942 {
    static int n;
    static int list[];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list= new int[n+1];
        check =new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            if(check[start][end]){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }

        System.out.println(sb.toString());


    }
    public static void solve(){
        for(int i=1; i<=n; i++){
            check[i][i] = true;
        }

        for(int i=1; i<n; i++){
            if(list[i]==list[i+1]){
                check[i][i+1] = true;
            }
        }

        for(int i=2; i<n; i++){
            for(int k=1; k<=n-i; k++){
                if(list[k]==list[k+i] && check[k+1][k+i-1]){
                    check[k][k+i] = true;
                }
            }
        }

    }
}
