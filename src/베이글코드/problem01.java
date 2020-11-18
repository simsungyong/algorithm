package 베이글코드;

public class problem01 {
    public static void main(String[] args) {
        int arr [][] = {{1,0,0,1},{0,1,0,1}, {1,0,1,0}, {0,1,0,1}, {0,0,1,0},{1,0,0,0}};
        solution(5,arr);
    }
    public static int[] solution(int n, int[][] ladder) {
        int[] answer = new int[n];
        int input [][] = new int [ladder.length][n];
        for(int i=0; i<ladder.length; i++){
            for(int k=0; k<n-1; k++){
                if(ladder[i][k]==1){
                    input[i][k] =1;
                    input[i][k+1] = 2;
                }
            }
        }
        for(int i=0; i<n; i++){
            int ans = search(input, i);
            answer[i]  = ans;
        }


        return answer;
    }


    public static int search(int [][] input, int x){
        int h = 0;
        int index=x;
        while(h<input.length){
            if(input[h][index]==0){
                h++;
                continue;
            }

            if(input[h][index] ==1){
                index = index+1;
                h++;
                continue;
            }

            if(input[h][index]==2){
                index=index-1;
                h++;
                continue;
            }
        }

        return index+1;
    }
}
