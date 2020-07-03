package back10026;

import java.util.Scanner;

public class problem10026 {
        static int total;
        static int input [][];
        static boolean check [][];
        static int dfsX []= {0,1,-1,0};
        static int dfsY [] = {-1,0,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        input = new int[n+2][n+2];
        check = new boolean[n+2][n+2];

        for(int i=1; i<=n; i++){
            String temp = sc.next();
            for(int k=1; k<=n; k++){
                input[i][k] = temp.charAt(k-1);
            }
        }//R->82, B=>66, G=>71

        //normal
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(check[i][k] == false){
                    dfs(i, k);
                    total++;
                }
            }
        }
        System.out.println(total);

        //색맹
        check = new boolean[n+2][n+2];
        total = 0;
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(check[i][k] == false){
                    dfscolor(i, k);
                    total++;
                }
            }
        }
        System.out.println(total);



    }

    public static void dfs(int i, int k){
        int x,y;
        check[i][k] = true;
        for(int l=0; l<4; l++){
            x = i+dfsX[l];
            y = k+dfsY[l];
            if(input[x][y] == input[i][k] && check[x][y] == false){
                dfs(x,y);
            }
        }
    }
    public static void dfscolor(int i, int k){
        int x,y;
        check[i][k] = true;
        int temp = input[i][k];
        for(int l=0; l<4; l++){
            x = i+dfsX[l];
            y = k+dfsY[l];
            if(temp==66){
                if(input[x][y] == input[i][k] && check[x][y] == false){
                    dfscolor(x,y);
                }
            }else{
                if((input[x][y] == 82 || input[x][y]==71) && check[x][y]==false){
                    dfscolor(x,y);
                }
            }
        }
    }
}
