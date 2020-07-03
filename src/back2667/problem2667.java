package back2667;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem2667 {
        static int count;
        static int total;
        static int input [][] ;
        static boolean check [][];
        static int dfsX []= {0,1,-1,0};
        static int dfsY [] = {-1,0,0,1};
        static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        input = new int[n+2][n+2];
        check = new boolean [n+2][n+2];
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            String temp = sc.next();
            for(int k=1; k<=n; k++){
                input[i][k] = temp.charAt(k-1)-'0';
            }
        }


        for(int i =1; i<=n; i++){
            for (int k =1; k<=n; k++){
                if(check[i][k]==false && input[i][k]==1){
                    count=0;
                    dfs(i,k);
                    list.add(count);
                    total++;
                }
            }
        }

        Collections.sort(list);


        System.out.println(total);
        for(int i =0; i<list.size(); i++){
            System.out.println(list.get(i));
        }



    }
    public static void dfs(int i, int k){
        check[i][k] = true;
        int x, y;
        count++;
        for(int l = 0; l<4; l++){
            x= i+dfsX[l];
            y= k+dfsY[l];
            if(check[x][y] == false && input[x][y] ==1){
                dfs(x,y);
            }
        }
    }
}

