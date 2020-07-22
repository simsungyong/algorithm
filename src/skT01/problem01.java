package skT01;

public class problem01 {
    public static void main(String[] args) {
        int a = solution(3,7);
        System.out.println(a);
    }
    public static int solution(int A,int B){
        int answer=0;
        Long l1 = Long.valueOf(A);
        Long l2 = Long.valueOf(B);
        String bit = Long.toBinaryString(l1*l2);
        char chars[] = bit.toCharArray();
        for(char ch: chars){
            if(ch=='1'){
                answer++;
            }
        }
        return answer;
    }
}
