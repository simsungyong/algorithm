package programDPtriangle;


public class problemDP3 {
    public static void main(String[] args) {
        int [][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(arr));
    }
    public static int solution(int[][] triangle) {
        int depth = triangle.length;
        int answer = triangle[0][0];
        for(int i=1; i<depth; i++){
            for(int k=0; k<triangle[i].length; k++){
                if(k==0){
                    triangle[i][k] = triangle[i-1][0]+triangle[i][k];
                    answer = Math.max(answer, triangle[i][k]);
                }else if(k==triangle[i].length-1){
                    triangle[i][k] = triangle[i-1][triangle[i].length-2]+triangle[i][k];
                    answer = Math.max(answer, triangle[i][k]);

                }else{
                    triangle[i][k] = Math.max(triangle[i-1][k-1], triangle[i-1][k])+triangle[i][k];
                    answer = Math.max(answer, triangle[i][k]);
                }
            }
        }
        return answer;
    }
}
