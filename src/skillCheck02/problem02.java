package skillCheck02;

public class problem02 {
    public static void main(String[] args) {
        String tmp = "01041753329";
        String answer = solution(tmp);
        System.out.print(answer);
    }
    public static String solution(String num){
        StringBuilder sb = new StringBuilder();
        int length = num.length();
        for(int i = 0; i<length; i++){
            if(i<length-4){
                sb.append("*");
            }else{
                sb.append(num.substring(i,i+1));
            }
        }
        return sb.toString();
    }
}
