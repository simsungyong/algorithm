package back4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problem4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> q = new LinkedList<>();
        while(true){
            Stack<String> stack = new Stack<>();
            String s= br.readLine().replaceAll(" ","/") ;
            if(s.equals("."))
                break;
            boolean check = false;
            for(int i=0; i<s.length(); i++){
                String cnt = s.substring(i,i+1);

                if(cnt.equals("(")||cnt.equals("[")){
                    stack.push(cnt);

                }else if(cnt.equals(")")){
                    if(!stack.isEmpty() && stack.peek().equals("(")){
                        stack.pop();

                    }else{
                        check = true;
                        break;
                    }
                }else if(cnt.equals("]")){
                    if(!stack.isEmpty() && stack.peek().equals("[")){
                        stack.pop();
                    }else{
                        check = true;
                        break;
                    }
                }
            }

            if(stack.isEmpty() && !check){
                q.add("yes");
            }else{
                q.add("no");
            }
        }
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
