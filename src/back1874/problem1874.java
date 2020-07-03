package back1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problem1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean check[] = new boolean[n+1];
        int lastnum=0;
        boolean success_check = true;
        Stack<Integer> stack = new Stack<>();
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(!check[cnt]){
                for(int k=lastnum+1; k<=cnt; k++){
                    stack.push(k);
                    q.add("+");
                    check[k] = true;
                    lastnum = k;
                }
                stack.pop();
                q.add("-");
            }else {//스택에 들어있는경우
                if(stack.peek()==cnt) {//스택맨위에 있는 경우
                    stack.pop();
                    q.add("-");
                }else{//스택맨위에 있는 숫자가 같지 않은경우
                    success_check=false;
                    break;
                }
            }


        }

        if(success_check){
            while(!q.isEmpty()){
                System.out.println(q.poll());
            }
        }else{
            System.out.print("NO");
        }

    }
}
