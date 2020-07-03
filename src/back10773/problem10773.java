package back10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt==0){
                stack.pop();
            }else{
                stack.push(cnt);
            }
        }

        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
