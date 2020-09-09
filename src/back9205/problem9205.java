package back9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem9205 {
    static int storennum,startx,starty,endx,endy;
    static int criteria = 32768;
//    static boolean check[][];
    static ArrayList<Node> arr;
    static boolean answer = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++){
            answer = false;
            arr = new ArrayList<>();
            storennum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            startx = Integer.parseInt(st.nextToken())+criteria;
            starty = Integer.parseInt(st.nextToken())+criteria;
            for(int k=0; k<storennum; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())+criteria;
                int y =Integer.parseInt(st.nextToken())+criteria;
                arr.add(new Node(x,y,false));
            }
            st = new StringTokenizer(br.readLine());
            endx = Integer.parseInt(st.nextToken())+criteria;
            endy = Integer.parseInt(st.nextToken())+criteria;

            bfs();

            if(answer){
                sb.append("happy\n");
            }else{
                sb.append("sad\n");
            }
        }

        System.out.println(sb.toString());
    }

//    public static void dfs(int x, int y){
////        if(Math.abs(x-endx)+Math.abs(y-endy) <=1000){
////            answer = true;
////            return;
////        }
////
//        for(int i=0; i<arr.size(); i++){
////            int next_x = arr.get(i).x;
////            int next_y = arr.get(i).y;
////            if(Math.abs(x-next_x)+Math.abs(y-next_y) <=1000 && !arr.get(i).check && !answer){
////                arr.get(i).check = true;
////                dfs(next_x, next_y);
////                arr.get(i).check = false;
////            }
////        }
////    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startx, starty,true));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(Math.abs(tmp.x-endx)+Math.abs(tmp.y-endy)<=1000){
                answer = true;
                break;
            }
            for(int i=0; i<arr.size(); i++){
                int next_x = arr.get(i).x;
                int next_y = arr.get(i).y;


                if(Math.abs(tmp.x-next_x)+Math.abs(tmp.y-next_y) <=1000 && !arr.get(i).check){
                    arr.get(i).check = true;
                    q.add(new Node(next_x,next_y,true));
                }
            }

        }

    }
}
class Node{
    int x,y;
    boolean check;
    Node(int x, int y, boolean check){
        this.x=x;
        this.y=y;
        this.check = check;
    }
}

//dfs시간초과!난다
