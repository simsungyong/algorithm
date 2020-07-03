package wemap03;

import java.util.*;

public class wemap03 {
    static boolean check [][];
    static char arr[][];
    static int N=5;
    static int M=7;
    static int dfsX[] = {0, 1, -1, 0};
    static int dfsY[] = {-1, 0, 0, 1};
    static int [] alpabet ;
    static PriorityQueue<Prior> q ;
    static Map<Character, Integer> map1;

    static List<Character> list ;


    public static void main(String[] args) {
        String [] map = {"--*AB**", "AB*A*BA", "B*-A*BB", "*-A*A**", "BC*BC*C"};

        arr = new char[N][M];
        check = new boolean[N][M];
        alpabet = new int[26];
        Arrays.fill(alpabet,-1);
        for(int i=0; i<5; i++){
            arr[i] = map[i].toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int k=0; k<M; k++){
                if(arr[i][k]-'A' >= 0 && !check[i][k]){
                    alpabet[arr[i][k]-'A']++;
                    map1 = new HashMap<>();
                    q = new PriorityQueue<>();
                    war(i,k);
                    list = new ArrayList<>();
                    list.addAll(map1.keySet());
                    for(char temp : list){
                        q.add(new Prior(temp, map1.get(temp)));
                    }

                }
            }
        }

        for(int i=0; i<N; i++){
            for(int k=0; k<M; k++){
                System.out.print(arr[i][k]-'A'+" ");
            }
            System.out.println();
        }



    }
    public static void war(int i, int k){
        check[i][k] = true;
        if(map1.containsKey(arr[i][k])){
            map1.replace(arr[i][k] , map1.get(arr[i][k])+1);
        }else{
            map1.put(arr[i][k], 1);
        }



        int tempx,tempy;
        for(int l=0; l<4; l++){
            tempx = i+dfsX[l];
            tempy = k+dfsY[l];
            if((tempx >=0 && tempx<N) && (tempy>=0 && tempy<M)) {
                if(!check[tempx][tempy] && arr[tempx][tempy]-'A'!= -23){
                    war(tempx, tempy);
                }

            }
        }
    }

}
class Prior implements Comparable<Prior>{
    char alpa;
    int num;


    public Prior(char alpa, int num){
        this.alpa = alpa;
        this.num = num;

    }
    @Override
    public int compareTo(Prior o) {
        if(o.num > this.num){
            return -2;
        }else if(o.num==this.num){
            if(o.alpa-'A' < this.alpa-'A'){
                return -1;
            }else{
                return 1;
            }
        }else{
            return 2;

        }
    }
}
