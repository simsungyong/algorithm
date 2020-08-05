package programmersLock;

import java.util.LinkedList;
import java.util.Queue;

public class problem {
    static int n;
    static Queue<Node> q = new LinkedList<>();

    static int size;
    public static void main(String[] args) {
        n = 5;
        int key[][]= {{0,0,0,0,1},{0,0,0,0,0},{0,1,0,0,0},{1,0,0,0,1},{0,0,0,0,0}};
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(key[i][k]==1){
                    q.add(new Node(i,k));
                }
                System.out.print(key[i][k]+" ");
            }
            System.out.println();
        }
        size = q.size();
        System.out.println();

        key = rotateKey();
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                System.out.print(key[i][k]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] rotateKey(){
        int newKey[][] = new int[n][n];
        for(int i=0; i<size ; i++){
            Node tmp= q.poll();
            int newX = tmp.y;
            int newY = Math.abs(tmp.x-(n-1));
            newKey[newX][newY] = 1;
            q.add(new Node(newX,newY));
        }
        return newKey;
    }
}
class Node{
    int x,y;
    Node(int x, int y){
        this.x=x; this.y=y;
    }
}
