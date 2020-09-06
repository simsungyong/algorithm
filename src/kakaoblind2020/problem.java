package kakaoblind2020;

import java.util.ArrayList;

public class problem {
    static int arr[][][];
    static int N;
    static int num;
    public static void main(String[] args) {
        int N=4;
//        int input[][] = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
//        int input[][] = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int input[][] = {{0,0,0,1},{4,0,0,1},{2,0,0,1},{0,1,1,1},{1,1,1,1},{3,1,1,1},{2,0,0,0},{3,1,0,1},{0,2,1,1},{0,2,0,1},{0,2,1,1},{3,2,1,1},{1,1,1,0},{2,2,1,1},{2,2,0,1},{2,3,1,1},{1,2,1,1},{4,0,0,0}};
        int a [][] = solution(N,input);

        for(int i=0; i<=N; i++){
            for(int k=0; k<=N; k++){
                for(int l=0; l<2; l++){
                    if(arr[i][k][l]!=0){
                        System.out.println(i+" "+k+" "+(arr[i][k][l]-1));
                    }
                }
            }
        }
    }

    public static int [][] solution(int n, int [][] build_frame){

        num =0;
        arr = new int[n+1][n+1][2];
        N = n;

        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int kind = build_frame[i][2];
            int crdel = build_frame[i][3];
            if(crdel==1){
                create(x,y,kind);
            }else{

                delete(x,y,kind);
            }

        }
        int answer[][]= new int[num][3];
        int index=0;
        for(int i=0; i<=n; i++){
            for(int k=0; k<=n; k++){
                for(int l=0; l<2; l++){
                    if(arr[i][k][l]!=0){
                        answer[index][0] = i;
                        answer[index][1] = k;
                        answer[index][2] = arr[i][k][l]-1;
                        index++;
                    }
                }
            }
        }

        return answer;
    }

    public static void create(int x, int y, int kind){
        if (kind == 0) {
            boolean con = createPilar(x,y);
            if(con){

                arr[x][y][0] = 1;

                num++;
            }
        }else{
            boolean con = createBo(x,y);
            if(con){
                arr[x][y][1] = 2;
                num++;
            }
        }

    }
    public static void delete(int x, int y, int kind){
        int v = arr[x][y][kind];
        arr[x][y][kind]=0;
        num--;
        out: for(int i=0; i<=N; i++){
            for(int k=0; k<=N; k++){

                if(arr[k][i][0]==1){
                    if(!createPilar(k,i)){
                        arr[x][y][kind]=v;
                        num++;
                        break out;
                    }
                }

                if(arr[k][i][1]==2){
                    if(!createBo(k,i)){
                        arr[x][y][kind]=v;
                        num++;
                        break out;
                    }
                }
            }
        }

    }

    public static boolean createPilar(int x, int y){
        if(y==0 || arr[x][y-1][0]==1 || arr[x][y][1]==2 || ( x-1>=0&& arr[x-1][y][1]==2)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean createBo(int x, int y){
        if(x==0){
            if(arr[0][y-1][0]==1 || arr[1][y-1][0]==1){
                return true;
            }else{
                return false;
            }
        }else{

            if(arr[x][y-1][0]==1 || arr[x+1][y-1][0]==1 || (arr[x-1][y][1]==2 && arr[x+1][y][1]==2) ){
                return true;
            }else{
                return false;
            }
        }
    }
}
