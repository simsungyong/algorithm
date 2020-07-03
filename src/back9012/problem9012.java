package back9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            Stack<Integer> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            boolean check = false;
            for(int k=0; k<s.length(); k++){
                String cnt = s.substring(k,k+1);
                if(cnt.equals("(")){
                    stack.push(1);
                }else{
                    if(stack.size()==0){
                        check = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(stack.size()==0 && !check ){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
