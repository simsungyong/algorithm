package skT02;

public class problem02 {
    public static void main(String[] args) {
        int a[] = {6,6,6,6,6};

        int []arr= solution(a,7,6);
        for(int d:arr){
            System.out.print(d+" ");
        }
    }
    public static int[] solution(int[] A, int F, int M) {

        int list_sum = (A.length+F)*M;
        for(int i=0; i<A.length;i++){
            list_sum-=A[i];
        }


        if(list_sum<F*1 || list_sum > F*6){
            int fail_answer[] = {0};
            return fail_answer;
        }else{
            int answer[] = new int[F];
            for(int i=0; i<F; i++){
                int leastnum = list_sum/(F-i);
                answer[i] = leastnum;
                list_sum -= leastnum;
            }
            return answer;
        }



    }
}
