package back1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1987 {
    static int moveX[]={-1,1,0,0};
    static int moveY[] = {0,0,1,-1};
    static boolean check[];
    static int r,c;
    static int arr[][];
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        check = new boolean[26];
        arr= new int[r][c];
        for(int i=0; i<r; i++){
            String tmp = br.readLine();
            for(int k=0; k<c; k++){
                int a = tmp.charAt(k)-'A';
                arr[i][k] = a;
            }
        }
        check[arr[0][0]] = true;
        dfs(0,0,1);
        System.out.println(answer);

    }

    public static void dfs(int x, int y, int num){
        answer = Math.max(num,answer);


        for(int i=0; i<4; i++){
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(nextX >=0 && nextX <r && nextY >=0 && nextY < c){
                if(!check[arr[nextX][nextY]]){
                    check[arr[nextX][nextY]] = true;
                    dfs(nextX,nextY,num+1);
                    check[arr[nextX][nextY]] = false;
                }
            }
        }
    }
}
//class Node {
//    int x;
//    int y;
//    int num;
//    Node(int x, int y, int num){
//        this.x=x;
//        this.y=y;
//        this.num = num;
//    }
//}
