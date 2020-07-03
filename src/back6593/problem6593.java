package back6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem6593 {
    static char arr[][];
    static int n,r,c;
    static int moveX[]={0,1,-1,0};
    static int moveY[]={1,0,0,-1};
    static int map[][];
    static int endpointX;
    static int endpointY;
    static Queue<Room> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answerarr = new ArrayList<>();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(n==0 && r==0&& c==0){
                break;
            }
            arr = new char[n*r][c];
            map = new int [n*r][c];
            for(int i=0; i<n*r; i++){
                if(i%r==0 && i!=0){
                    br.readLine();
                }
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                for(int k=0; k<c; k++){
                    map[i][k] = Integer.MAX_VALUE;
                    arr[i][k] = tmp.charAt(k);
                    if(arr[i][k]=='S'){
                        map[i][k]=0;
                        q.add(new Room(i,k));
                    }
                    if(arr[i][k]=='E'){
                        endpointX= i;
                        endpointY = k;
                    }

                }
            }
            br.readLine();

            dijstra();
            boolean answer = map[endpointX][endpointY] < Integer.MAX_VALUE ? true : false;
            if(answer){
                answerarr.add("Escaped in "+map[endpointX][endpointY]+" minute(s).");
            }else{
                answerarr.add("Trapped!");
            }

        }
        for(String a : answerarr){
            System.out.println(a);
        }
    }
    public static void dijstra(){
        while(!q.isEmpty()){
            Room room = q.remove();

            for(int i=0; i<4; i++){
                int x = room.x+moveX[i];
                int y = room.y + moveY[i];
                int floor = room.x/r;
                if(y>=0 && y<c && x >= r*floor && x<r*(floor+1)){
                    if(arr[x][y]!='#'){
                        if(map[x][y] > map[room.x][room.y] +1 ){
                            map[x][y]=map[room.x][room.y]+1;
                            q.add(new Room(x,y));
                        }
                    }
                }
            }

            if((room.x+r)<n*r){
                if(arr[room.x+r][room.y]!='#' && map[room.x+r][room.y] > map[room.x][room.y]+1){
                    map[room.x+r][room.y] = map[room.x][room.y]+1;
                    q.add(new Room(room.x+r,room.y));
                }
            }

            if((room.x-r)>=0){
                if(arr[room.x-r][room.y]!='#' && map[room.x-r][room.y] > map[room.x][room.y]+1){
                    map[room.x-r][room.y] = map[room.x][room.y]+1;
                    q.add(new Room(room.x-r,room.y));
                }
            }

        }
    }
}
class Room {
    int x, y;
    Room(int x, int y){
        this.x =x;
        this.y=y;
    }
}