package Line하반기.problem3;

public class answer3 {

    public static void main(String[] args) {
        int [] []arr = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
        solution(arr);
    }

    public static int solution(int[][] maze) {
        int answer = 0;
        int direction;
        int x=0;
        int y=0;
        if(maze[0][1]==0){
            direction = 2;
        }else{
            direction = 1;
        }

        while(true){

            if(direction==1){
                if((y+1)< maze.length && maze[x][y+1]==0){
                    y= y+1;
                    answer++;
                    direction = 2;
                }else{
                    if((x+1) >= maze.length || maze[x+1][y]==1){
                        direction = 4;
                    }else{
                        x = x+1;
                        answer++;
                    }
                }

            }else if(direction==2){
                if((x-1)>=0 && maze[x-1][y]==0){
                    x= x-1;
                    answer++;
                    direction=3;
                }else{
                    if((y+1) >= maze.length || maze[x][y+1]==1){
                        direction = 1;
                    }else{
                        y = y+1;
                        answer++;
                    }
                }



            }else if(direction==3){
                if((y-1)>=0 && maze[x][y-1]==0){
                    y= y-1;
                    answer++;
                    direction = 4;
                }else{
                    if( (x-1) < 0 || maze[x-1][y]==1){
                        direction = 2;
                    }else{
                        x = x-1;
                        answer++;
                    }
                }
            }else{
                if((x+1) < maze.length && maze[x+1][y]==0){
                    x= x+1;
                    answer++;
                    direction = 1;
                }else{
                    if((y-1) < 0 || maze[x][y-1]==1){
                        direction = 3;
                    }else{
                        y= y-1;
                        answer++;
                    }
                }
            }

            if(x==maze.length-1 && y == maze.length-1){
                break;
            }

        }

        return answer;
    }
}
