package movexCote;

public class movex02 {
    public static void main(String[] args) {
        int[] arr = {3,4,2,5,7,6,1};
        solution(7, arr);

    }

    public static void solution(int N, int[] sequence) {
        int answer = 0;
        for (int i = 0; i < sequence.length; i++) {
        int cnt;
        if (i == 0) {
            cnt = (sequence.length - sequence[i] + 1) > (sequence[i] - 1) ? sequence[i] - 1 : sequence.length - sequence[i] + 1;
        } else {
            cnt = (sequence.length - sequence[i-1] + sequence[i]) > Math.abs(sequence[i] - sequence[i - 1]) ? Math.abs(sequence[i] - sequence[i - 1]) : sequence.length - sequence[i-1] + sequence[i];

        }
        answer = answer+cnt;
        System.out.println(answer);
    }
}
}


//큰값빼는게 관건.