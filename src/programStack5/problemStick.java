package programStack5;

public class problemStick {
    public static void main(String[] args) {
        String arg = "()(((()())(())()))(())";
        System.out.print(solution(arg));
    }
    public static int solution(String arrangement) {
        int answer = 0;
        int sticknum=0;
        for(int i=0; i<arrangement.length(); i++){
            if(arrangement.charAt(i) == ')'){
                answer+=1;
                sticknum--;
            }
            else if(arrangement.charAt(i)=='('){
                if(arrangement.charAt(i+1)==')'){
                    answer += sticknum;
                    i++;
                }else{

                    sticknum++;
                }
            }
        }
        return answer;
    }
}
