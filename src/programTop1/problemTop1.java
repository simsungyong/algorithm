package programTop1;

public class problemTop1 {
    public static void main(String[] args) {
       int input []= {3,9,9,3,5,7,2};
       int [] arr = solution(input);
       for(int temp :arr){
           System.out.print(temp);
       }
    }
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=1; i<answer.length; i++){
            for(int k=i-1; k>=0; k--){
                if(heights[i] < heights[k]){
                    answer[i] = k+1;
                    break;
                }
            }

        }
        return answer;
    }
}
