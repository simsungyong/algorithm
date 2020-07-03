package movexCote;

public class movex01 {
    public static void main(String[] args) {
        int answer;
        answer = solution(7);
        System.out.println(answer);
    }
    public static int solution(int n){
        int x3 = 0;
        int x2 = 0;
        int x1 = 0;
        int x0 = 0;
        int x = 0;
        int o1 = 0;
        int o2 = 1;
        for (int i = 1; i <= n; i++) {
            x += x0;
            x0 = x1;
            x1 = x2;
            x2 = x3;
            x3 = o1;
            o1 = o2;
            o2 = (x0 + x1 + x2 + x3);
        }
        return (x + x0 + x1 + x2 + x3 + o1 + o2);

    }
}
