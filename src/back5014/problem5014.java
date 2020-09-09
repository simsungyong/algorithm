package back5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5014 {
    static int f,s,g,u,d;
    static boolean check[];
    static int answer =Integer.MAX_VALUE;
    static boolean iz = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        check = new boolean[f+1];
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        check[s] = true;
        dfs(s,0);



        if(iz){
            System.out.println(answer);
        }else{
            System.out.println("use the stairs");
        }


    }

    public static void dfs(int cnt, int num){
        if(cnt==g){
            iz = true;
            answer = Math.min(num, answer);
            return;
        }

        if(cnt <= g && u!=0&& (g-cnt)%u==0 ){  //u,d가 0일때 런타임에러조심
            iz = true;
            answer = Math.min(num+(g-cnt)/u, answer);
            return;
        }
        else if(cnt >= g &&d!=0 && (cnt-g)%d==0 ){
            iz = true;
            answer = Math.min(num+(cnt-g)/d, answer);
            return;
        }

        if(cnt+u <=f && !check[cnt+u]){
            check[cnt+u] = true;
            dfs(cnt+u, num+1);
            check[cnt+u] = false;
        }

        if(cnt-d >=1 && !check[cnt-d]){
            check[cnt-d] = true;
            dfs(cnt-d, num+1);
            check[cnt-d] = false;
        }



    }
}
