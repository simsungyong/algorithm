package back16236;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16236 {
    static int arr[][];
    static int n;
    static int shark_x, shark_y;
    static int shark_size;
    static ArrayList<point> arrlist = new ArrayList<point>();
    static boolean check[][];
    static int tmp_arr[][];
    static int []moveX={0,-1,0,1};
    static int []moveY={-1,0,1,0};
    static int total;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new boolean[n][n];
        tmp_arr = new int[n][n];
        shark_size=2;
        total = 0;
        count=0;


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k]==9){
                    shark_x = i;
                    shark_y = k;
                }
            }
        }

        solve(new point(shark_x, shark_y));
        System.out.println(total);



    }

    public static void solve(point tmp){
        while(true){
            find(tmp);
            if(arrlist.size()<=0){
                break;
            }

            tmp = choiceEat();
            tmp_arr = new int[n][n];
            check = new boolean[n][n];
        }

    }

    public static void find(point tmp){
        Queue<point> q = new LinkedList<point>();
        arrlist = new ArrayList<point>();
        check[tmp.x][tmp.y] = true;
        q.add(tmp);

        while(!q.isEmpty()){
            point d = q.remove();
            int x=d.x;
            int y=d.y;
            if(arr[x][y] < shark_size && arr[x][y] >=1 && arr[x][y]<=6){
                arrlist.add(new point(x,y));
            }

            for(int i=0; i<4; i++){
                int newx = x+moveX[i];
                int newy = y+moveY[i];
                if( newx>=0 && newx<n && newy>=0 && newy<n && !check[newx][newy] && tmp_arr[newx][newy]==0 && arr[newx][newy] <= shark_size){
                    tmp_arr[newx][newy] = tmp_arr[x][y]+1;
                    q.add(new point(newx,newy));

                }
            }
        }


    }

    public static point choiceEat(){
        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Integer> min_x = new ArrayList<>();
        ArrayList<Integer> min_y = new ArrayList<>();
        int min_dist;
        for(int i=0; i<arrlist.size(); i++){
            distance.add(tmp_arr[arrlist.get(i).x][arrlist.get(i).y]);
        }
        min_dist = Collections.min(distance);

        for(int i=0; i<arrlist.size(); i++){
            if(tmp_arr[arrlist.get(i).x][arrlist.get(i).y]==min_dist){
                min_x.add(arrlist.get(i).x);
                min_y.add(arrlist.get(i).y);
            }
        }

        int minX = Collections.min(min_x);
        int minY = Integer.MAX_VALUE;
        for(int i=0; i<min_x.size(); i++){
            if(min_x.get(i) == minX){
                if(minY > min_y.get(i)){
                    minY = min_y.get(i);
                }
            }
        }
        point dot = new point(minX, minY);
        arr[shark_x][shark_y] = 0;
        shark_x = minX;
        shark_y=minY;
        total += min_dist;
        arr[minX][minY]=9;

        count++;
        if(count == shark_size){
            shark_size++;
            count=0;
        }




        return dot;


    }
}

class point {
    int x,y;
    point(int x, int y){
        this.x =x;
        this.y =y;
    }
}
