package Samsung.블럭2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem12100 {
    static int n;
    static int temp[][];
    static int answer  = Integer.MIN_VALUE;
    static LinkedList<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int arr[][] = new int [n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr,0);
        System.out.println(answer);

    }

    public static void dfs(int arr[][], int num){
        if(num==5){

            return;
        }

        dfs(up(arr), num+1);
        dfs(down(arr), num+1);
        dfs(left(arr), num+1);
        dfs(right(arr), num+1);

    }

    public static int[][] up(int [][]arr){
        temp = new int[n][n];
        for(int y=0; y<n; y++){
            for(int x = 0; x<n; x++){
                if(arr[x][y]!=0){
                    if(q.isEmpty()){
                        q.add(new Node(arr[x][y],true));
                        continue;
                    }else{
                        if(q.getLast().check && q.getLast().value==arr[x][y]){
                            q.removeLast();
                            q.addLast(new Node(arr[x][y]*2, false));
                        }else{
                            q.addLast(new Node(arr[x][y], true));
                        }
                    }
                }

            }
            int index=0;
            while(!q.isEmpty()){
                temp[index][y] = q.poll().value;
                answer = Math.max(temp[index][y], answer);
                index++;
            }
        }
        return temp;

    }

    public static int[][] down(int [][]arr){
        temp = new int[n][n];
        for(int y=0; y<n; y++){
            for(int x = n-1; x>=0; x--){
                if(arr[x][y]!=0){
                    if(q.isEmpty()){
                        q.add(new Node(arr[x][y],true));
                        continue;
                    }else{
                        if(q.getLast().check && q.getLast().value==arr[x][y]){
                            q.removeLast();
                            q.addLast(new Node(arr[x][y]*2, false));
                        }else{
                            q.addLast(new Node(arr[x][y], true));
                        }
                    }
                }

            }
            int index=n-1;
            while(!q.isEmpty()){
                temp[index][y] = q.poll().value;
                answer = Math.max(temp[index][y], answer);
                index--;
            }
        }
        return temp;

    }


    public static int[][] right(int [][]arr){
        temp = new int[n][n];
        for(int x=0; x<n; x++){
            for(int y = n-1; y>=0; y--){
                if(arr[x][y]!=0){
                    if(q.isEmpty()){
                        q.add(new Node(arr[x][y],true));
                        continue;
                    }else{
                        if(q.getLast().check && q.getLast().value==arr[x][y]){
                            q.removeLast();
                            q.addLast(new Node(arr[x][y]*2, false));
                        }else{
                            q.addLast(new Node(arr[x][y], true));
                        }
                    }
                }

            }
            int index=n-1;
            while(!q.isEmpty()){
                temp[x][index] = q.poll().value;
                answer = Math.max(temp[x][index], answer);
                index--;
            }
        }
        return temp;

    }

    public static int[][] left(int [][]arr){
        temp = new int[n][n];
        for(int x=0; x<n; x++){
            for(int y = 0; y<n; y++){
                if(arr[x][y]!=0){
                    if(q.isEmpty()){
                        q.add(new Node(arr[x][y],true));
                        continue;
                    }else{
                        if(q.getLast().check && q.getLast().value==arr[x][y]){
                            q.removeLast();
                            q.addLast(new Node(arr[x][y]*2, false));
                        }else{
                            q.addLast(new Node(arr[x][y], true));
                        }
                    }
                }

            }
            int index=0;
            while(!q.isEmpty()){
                temp[x][index] = q.poll().value;
                answer = Math.max(temp[x][index], answer);
                index++;
            }
        }
        return temp;

    }

}

class Node{
    int value;
    boolean check;
    Node(int value, boolean check){
        this.value = value;
        this.check = check;
    }
}
//시간과 메모리 줄여보자.!!