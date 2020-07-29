package skillCheck05;

import java.util.Stack;
import java.util.stream.StreamSupport;

public class problem05 {
    public static void main(String[] args) {
        String s = "baabaa";

        System.out.print(solution(s));
    }

    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stack.size() ==0 ){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek()==s.charAt(i)){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        if(stack.size()==0){
            return 1;
        }else{
            return 0;
        }
    }

}
