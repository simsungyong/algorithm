package wintercote;

import java.util.LinkedList;
import java.util.Queue;

public class problem03 {
    static int mx[] = {1,-1,0,0};
    static int my[] = {0,0,1,-1};
    static boolean check[][];
    public static void main(String[] args) {
        int arr [][] = {{0,0,1,1},{1,1,1,1},{2,2,2,1},{0,0,0,2}};
    }
    public static int[] solution(int[][] v){
        int[] answer = new int[3];
        check = new boolean[v.length][v.length];
        for(int i=0; i<v.length; i++){
            for(int k=0; k<v.length; k++){
                if(!check[i][k]){
                    bfs(i,k,v[i][k],v);
                    answer[v[i][k]]++;
                }
            }
        }

        for(int tmp:answer){
            System.out.println(tmp);
        }
        return answer;
    }
    public static void bfs(int x, int y, int temp, int arr[][]){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        check[x][y] = true;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int nextx = tmp.x+mx[i];
                int nexty = tmp.y + my[i];
                if(nextx>=0 && nextx<arr.length && nexty>=0 && nexty < arr.length){
                    if(!check[nextx][nexty] && arr[nextx][nexty]==temp){
                        check[nextx][nexty] = true;
                        q.add(new Node(nextx, nexty));
                    }
                }
            }
        }

    }

}
class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this. y=y ;

    }
}