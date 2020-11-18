package back2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2579 {
    static int n,m;
    static int input[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n][m];
        check = new boolean[n][m];
        int answer = 0;

        for(int i=0; i<n; i++){

            String tmp = br.readLine();
            for(int k=0; k<m; k++){
                char s = tmp.charAt(k);
                if(s=='L'){
                    input[i][k] = 0;
                }else{
                    input[i][k] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int k=0; k<m; k++){
                if(!check[i][k] && input[i][k]==0){
//                    bfs(i,k);
                }
            }
        }
    }

//    public static int bfs(int x, int y){
//        int num=0;
//
//    }

}

class Node {
    int x,y;

    Node(int x, int y){
        this.x=x;
        this.y=y;

    }
}

