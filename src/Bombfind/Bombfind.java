package Bombfind;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Bombfind {

    static int height = 10;
    static int width = 10;
    static int bomb_num = 10;
    static int[][] bomb;
    static Queue<State> bomb_info;
    static Random random;
    static HashSet<Integer> set;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        bomb = new int[height][width];
        random = new Random();
        set = new HashSet<>();

        initialBomb();  //지뢰 랜덤 생성

        findBomb();     //지뢰 정보만을 담은 큐를 사용할 수 있는 경우 메서드입니다.
        //findBomb02(); //지뢰정보가 전체 배열에 숨겨져 있는 경우 메서드입니다.

        for(int i=0; i<height; i++){
            for(int k=0; k<width; k++){
                sb.append(bomb[i][k]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void initialBomb(){       //지뢰를 랜덤 생성합니다.

        bomb_info = new LinkedList<>();     //지뢰의 좌표 정보를 담아놓은 큐를 설정합니다.

        while (set.size() < bomb_num){      //중복없는 난수를 위해 HashSet을 이용하였습니다.

            int random_num  = random.nextInt(height*width);     //난수 생성
            set.add(random_num);
        }

        int x = 0;
        int y = 0;

        for(int tmp : set){
            x = tmp/width;
            y = tmp%width;
            bomb[x][y] = 9;
            bomb_info.add(new State(x,y));
        }

    }

    public static void findBomb(){      //지뢰의 좌표 정보만을 가진 큐가 주어지는 경우, 모든 사각형에 대한 숫자를 찾는 메서드입니다.

        while(!bomb_info.isEmpty()){    //지뢰의 좌표가 저장된 큐에서 하나씩 빼내와 탐색합니다.

            State cnt_bomb = bomb_info.poll();

            for(int aroundX=-1; aroundX <2; aroundX++) {    //주변 8개의 칸을 탐색합니다.
                for (int aroundY = -1; aroundY < 2; aroundY++) {

                    if( aroundX== 0 && aroundY==0 ){        //자기 자신은 탐색하지않습니다.
                        continue;
                    }

                    if(cnt_bomb.x+aroundX>=0 && cnt_bomb.x+aroundX<height && cnt_bomb.y+aroundY >=0 && cnt_bomb.y+aroundY < width){ //좌표의 상하 범위를 체크합니다.
                        if(bomb[cnt_bomb.x+aroundX][cnt_bomb.y+aroundY]!=9){ //폭탄인 자리는 다른 주변지뢰의 정보를 표시하지 않습니다.
                            bomb[cnt_bomb.x+aroundX][cnt_bomb.y+aroundY]++;
                        }
                    }
                }
            }
        }
    }
    public static void findBomb02(){    //지뢰의 정보만을 담은 큐가 제공되지 않고, 전체 배열에 지뢰가 숨어있을때 모든 사각형에 대한 숫자를 찾는 메서드입니다.

        for(int i =0; i<height; i++){   //지뢰의 좌표를 모르는 상태이기에 처음부터 탐색합니다.
            for(int k=0; k<width; k++){

                if(bomb[i][k] == 9){
                    continue;
                }

                int bomb_count = 0;

                for(int aroundX=-1; aroundX <2; aroundX++){     //주변 8개의 칸을 탐색합니다.
                    for(int aroundY=-1; aroundY <2; aroundY++){

                        int newX = i+aroundX;
                        int newY = k+aroundY;

                        if(newX == i && newY==k){
                            continue;
                        }

                        if(newX>=0 && newX<height && newY >=0 && newY < width){
                            if(bomb[newX][newY] == 9){  //주변에 지뢰가 있을시, 갯수를 더해줍니다.
                                bomb_count++;
                            }
                        }
                    }
                }
                bomb[i][k] = bomb_count;
            }
        }
    }
}

class State{
    int x,y;
    State(int x, int y){
        this.x=x;
        this.y=y;
    }
}
