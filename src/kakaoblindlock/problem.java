package kakaoblindlock;

import java.util.LinkedList;
import java.util.Queue;

public class problem {
    static Queue<Node> q;
    static int m,n;
    static int num=0;
    public static void main(String[] args) {
        int key[][]={{0,0,0},{1,0,0},{0,1,1}};
        int lock[][]= {{1,1,1},{1,1,0},{1,0,1}}; //0을 찾자
        System.out.println(solution(key,lock));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        q = new LinkedList<>();
        m = key.length;
        n = lock.length;

        boolean answer = false;
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(lock[i][k]==0){
                    num++;
                }
                if(i<m && k<m && key[i][k]==1){
                    q.add(new Node(i,k));
                }
            }
        }

        if(num==0 || (q.size()==m*m && num==m*m && n==m)){
            return true;
        }

        if(num > m*m){
            return false;
        }

        for(int i=0; i<4; i++){
            rotate_key(q.size());
            if(move(lock)){
                answer =  true;
                break;
            }
        }
        return answer;
    }

    public static void rotate_key(int size){

        for(int i=0; i<size; i++){
            Node tmp = q.poll();
            q.add(new Node(tmp.y, Math.abs((m-1)-tmp.x)));
        }

    }

    public static boolean move(int[][] lock){
        boolean check = false;
        out: for(int x = -(n-1); x<n; x++){
            for(int y = -(n-1); y<n; y++){
                check = sol(x,y,lock);
                if(check){
                    break out;
                }
            }
        }
        return check;
    }

    public static boolean sol(int x, int y,int[][] lock){

        int size = q.size();
        int correctN=0;
        boolean isWrong = true;
        for(int i=0; i<size; i++){
            Node tmp = q.poll();
            int newX = tmp.x+x;
            int newY = tmp.y+y;
            if(newX>=0 && newX < n && newY>=0 && newY<n){
                if(lock[newX][newY]==1 ){
                    isWrong = false;
                }else{
                    correctN++;
                }

            }
            q.add(tmp);
        }
        if(correctN==num && isWrong){
            return true;
        }else{
            return false;
        }
    }
}
class Node{
    int x,y;
    Node(int x, int y){
        this.x =x;
        this.y = y;
    }
}