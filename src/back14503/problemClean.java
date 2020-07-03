package back14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemClean {
    static int map[][];
    static int cleannum;
    static int []moveX={0,-1,0,1};
    static int []moveY={-1,0,1,0};
    static int []movebackX={1,0,-1,0};
    static int []movebackY={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        map[x][y] = 2;
        cleannum++;
        findLeft(x,y,direction,0);





        System.out.println(cleannum);



    }


    public static void findLeft(int x, int y, int direction, int num){

        int newx=moveX[direction]+x;
        int newy = moveY[direction]+y;
        int newdir = direction==0 ? 3 : direction-1;

        if(map[newx][newy]==1 || map[newx][newy]==2){

            if(num==3){
                moveback(x,y,newdir);
            }else{
                findLeft(x, y,newdir ,num+1);
            }
        }else{


            map[newx][newy]=2;
            cleannum++;
            findLeft(newx,newy,newdir,0);
        }

    }
    public static void moveback(int x, int y, int dir){
        int newx = movebackX[dir]+x;
        int newy= movebackY[dir]+y;
        if(map[newx][newy]!=1){
            findLeft(newx,newy,dir,0);
        }else{
            return;
        }
    }

}
