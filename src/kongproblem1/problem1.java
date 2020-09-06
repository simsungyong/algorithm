package kongproblem1;

import java.util.Stack;

public class problem1 {
    public static void main(String[] args) {
        System.out.println(func("hello"));
    }

    public static String func(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o'|| s.charAt(i)=='u'){
                stack.add(s.charAt(i));
            }
        }

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o'|| s.charAt(i)=='u'){
                char tmp = stack.pop();
                sb.append(tmp);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
