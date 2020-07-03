package movexCote;

public class movex05 {
    public static void main(String[] args) {
        int arr [] = {4,3,6,3,1,10};
        solution(arr, 3);
    }
    public static void solution(int [] estimates, int k){
        int answer = 0;
        int cnt=0;
        for(int i=0; i<estimates.length; i++){
            if(i < k){
                answer+=estimates[i];
                cnt +=estimates[i];
            }else{
                cnt = cnt + estimates[i] - estimates[i-k];
                if(answer < cnt){
                    answer = cnt;
                }
            }
            System.out.println(cnt);
            System.out.println("답: " + answer);
        }
    }
}

//연속된 k개의 합 제일 큰거 반환.