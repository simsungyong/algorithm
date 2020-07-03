package programBudget;

public class budget {
    public static void main(String[] args) {
        int [] arr = {120, 110, 140, 150};
        int M = 485;
        System.out.println(solution(arr, M));

    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;
        int min=0;
        int max=0;
        for(int i : budgets){
            max = Math.max(max, i);
        }
        int sum=0;
        while(true){
            int tempsum=0;
            if(min > max){
                break;
            }
            int mid = (min+max)/2;
            for(int i: budgets){
                if(i > mid){
                    tempsum += mid;
                }else{
                    tempsum +=i;
                }
            }
            if(tempsum > M){
                max = mid-1;
            }else{
                 min= mid+1;
                 answer = Math.max(sum, mid);
            }
        }
        return answer;
    }
}
