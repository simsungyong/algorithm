package programDP2;

public class problemDP2 {
    public static void main(String[] args) {
        int N= 5;
        System.out.println(solution(N));
    }
    public static long solution(int N) {
        long answer = 0;
        int [] arr = new int[N+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2 ; i<=N; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        answer = 4*arr[N-1] + 2*arr[N-2];
        return answer;
    }
}
