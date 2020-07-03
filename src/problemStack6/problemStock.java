package problemStack6;

public class problemStock {
    public static void main(String[] args) {
        int prices [] = {1,2,3,2,3};
        int answer [] = solution(prices);
        for(int temp : answer){
            System.out.print(temp);
        }

    }
    public static int[] solution(int[] prices) {
        int [] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){
            for(int k=i+1; k<prices.length; k++){
                if(prices[i] > prices[k]){
                    answer[i] = k-i;
                    break;
                }
                if(k==prices.length-1){
                    answer[i] = prices.length-i-1;
                }

            }

        }
        return answer;
    }
}
