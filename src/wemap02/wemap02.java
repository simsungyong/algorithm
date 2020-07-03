package wemap02;

public class wemap02 {
    static int N,M;
    static int [][] map ={{1,0,0,0},{0,0,0,0},{0,0,0,1}};;
    public static void main(String[] args) {
//Math.round(pie*100)/100.0
        N = 3;
        M =4;

        System.out.println(solution(N,M,map));
    }
    public static double  solution(int N, int M, int map[][]){
        double answer = Integer.MAX_VALUE;
        double limit =  (N-1)*(N-1)+(M-1)*(M-1);
        for(int k=0; k<N; k++){
            for(int m=0; m<M; m++){
                    if(map[k][m]==1){
                        answer = Math.min(answer, find(k,m));
                    }
                }
            }
            return answer;
    }
    public static double find(int k, int m){
        double min=Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            for(int l =0; l<M; l++){
                if(map[i][l]==1 ){
                    if(k==i && m==l){
                        continue;
                    }else{
                        double length = (k-i)*(k-i)+(m-l)*(m-l);
                        System.out.print(length+" ");
                        min = Math.min(min, Math.round(Math.sqrt(length)*100)/100.0);
                    }
                }
            }
        }
        return min;
    }


}
