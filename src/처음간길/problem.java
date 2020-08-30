package 처음간길;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class problem {
    static ArrayList<Integer> arr[][] = new ArrayList[11][11];
    static int answer;
    static int length;
    static Queue<Character> q = new LinkedList<>();

    public static void main(String[] args) {
        String str = "LULLLLLLU";
        System.out.print(solution(str));
    }
    public static int solution(String dirs) {
        answer = 0;
        length = dirs.length();
        for(int i=0; i<length; i++){
            q.add(dirs.charAt(i));
        }

        for(int i=0; i<11; i++){
            for(int k=0; k<11; k++){
                arr[i][k] = new ArrayList<>();
            }
        }

        move();

        return answer;
    }

    public static void move(){
        int x = 5;
        int y= 5;

        while(!q.isEmpty()){
            char tmp = q.poll();
            boolean con = true;
            switch (tmp){
                case 'U':
                    if(x-1>=0 && x<11 && y>=0 && y<11){
                        for(int i=0; i<arr[x-1][y].size(); i++){
                            if(arr[x-1][y].get(i)==3){
                                con = false;
                                break;
                            }
                        }
                        if(con){
                            answer++;
                            arr[x-1][y].add(3);
                            arr[x][y].add(1);
                        }

                        x = x-1;
                    }
                    break;
                case 'D':
                    if(x>=0 && x+1<11 && y>=0 && y<11){
                        for(int i=0; i<arr[x+1][y].size(); i++){
                            if(arr[x+1][y].get(i)==1){
                                con = false;
                                break;
                            }
                        }
                        if(con){
                            answer++;
                            arr[x+1][y].add(1);
                            arr[x][y].add(3);
                        }
                        x = x+1;
                    }
                    break;
                case 'L':
                    if(x>=0 && x<11 && y-1>=0 && y<11){
                        for(int i=0; i<arr[x][y-1].size(); i++){
                            if(arr[x][y-1].get(i)==4){
                                con = false;
                                break;
                            }
                        }
                        if(con){
                            answer++;
                            arr[x][y-1].add(4);
                            arr[x][y].add(2);
                        }
                        y =y-1;
                    }
                    break;
                case 'R':
                    if(x>=0 && x<11 && y>=0 && y+1<11){
                        for(int i=0; i<arr[x][y+1].size(); i++){
                            if(arr[x][y+1].get(i)==2){
                                con = false;
                                break;
                            }
                        }
                        if(con){
                            answer++;
                            arr[x][y+1].add(2);
                            arr[x][y].add(4);
                        }
                        y =y +1;
                    }
                    break;

            }

        }


    }
}
