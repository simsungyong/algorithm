package skillCheck04;

public class skillCheck04 {
    public static void main(String[] args) {
        int num = 78;
        System.out.println(solution(num));
    }
    public static int solution(int n){
        String tmp = Integer.toBinaryString(n);
        int one_n = 0;
        for(int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i)-'0'==1){
                one_n++;
            }
        }
        int num = n+1;
        while(true){
            String cnt = Integer.toBinaryString(num);
            int tempOne=0;
            for(int i=0; i<cnt.length(); i++){
                if(cnt.charAt(i)-'0'==1){
                    tempOne++;
                }
            }
            if(one_n == tempOne){
                break;
            }
            num++;
        }
        return num;
    }
}
