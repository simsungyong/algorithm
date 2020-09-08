package Samsung.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem {
    static int arr[][];
    static int n;
    static Queue<Node> q;
    static LinkedList<Bam> baam = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        q = new LinkedList<>();
        int apple = Integer.parseInt(br.readLine());
        for(int i=0; i<apple; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int change = Integer.parseInt(br.readLine());
        for(int i=0; i<change; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            q.add(new Node(t,d));
        }
        baam.add(new Bam(0,0));

        move();



    }

    public static void move(){
        int time = 0;
        int dir = 1;
        while(true){
            time++;
            int tempX = baam.get(0).x;
            int tempY = baam.get(0).y;
            if(dir==1){
                baam.addFirst(new Bam(tempX, tempY + 1));


                if(q.size()>0 && q.peek().time==time){
                    if(q.poll().dir.equals("D")){
                        dir = 2;
                    }else{
                        dir = 4;
                    }
                }

            }
            else if(dir==2){

                baam.addFirst(new Bam(tempX+1, tempY));

                if(q.size()>0 && q.peek().time==time){
                    if(q.poll().dir.equals("D")){
                        dir = 3;
                    }else{
                        dir = 1;
                    }
                }
            }
            else if(dir==3){
                baam.addFirst(new Bam(tempX, tempY-1));


                if(q.size()>0 && q.peek().time==time){
                    if(q.poll().dir.equals("D")){
                        dir = 4;
                    }else{
                        dir = 2;
                    }
                }
            }
            else if(dir==4){
                baam.addFirst(new Bam(tempX-1, tempY));

                if(q.size()>0 && q.peek().time==time){
                    if(q.poll().dir.equals("D")){
                        dir = 1;
                    }else{
                        dir = 3;
                    }
                }
            }
            int v = isCon();
            if(v==0){
                break;
            }else if(v==2){
                baam.removeLast();
            }

        }
        System.out.println(time);

    }

    public static int isCon(){
        int x = baam.getFirst().x;
        int y = baam.getFirst().y;


        if(x<0 || x>=n || y <0 || y>=n){
            return 0;
        }

        for(int i=1; i<baam.size(); i++){
            if(x==baam.get(i).x && y == baam.get(i).y){
                return 0;
            }
        }

        if(arr[x][y]==1){
            arr[x][y]=0;
            return 1;
        }else{
            return 2;
        }

    }


}
class Node{
    int time;
    String dir;
    Node(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}
class Bam{
    int x, y;
    Bam(int x, int y){
        this.x=x;
        this.y=y;
    }
}
