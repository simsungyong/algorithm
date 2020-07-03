package NBP02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problem {
    static Queue<String> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static String s = "3(lll2(1(p)q))";
            //"3(l2(2(k)q)ab1(1(mm)nn))";
            //
    public static void main(String[] args) {
        String answer="";
        solution(s);
        while(!q.isEmpty()){
            answer += q.poll();
        }
        System.out.println(answer);
    }
    public static void solution(String s){

        Stack<Integer> st = new Stack<>();
        boolean numbcheck=false;
        String tmp_s="";
        int last_index=0;
        int depth=0;

        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);

            if(tmp-'0'<10 && tmp-'0'>=0){
                depth++;

                if(!tmp_s.equals("")){

                    sb.append(tmp_s);
                    tmp_s="";
                }

                if(s.charAt(i+1)-'0'<0 && s.charAt(i+1)>=10){
                    st.push(Integer.parseInt(s.substring(last_index, i+1)));
                    numbcheck=true;
                }


            }
            else if(tmp=='('){
                last_index=i+1;
                continue;
            }
            else if(tmp==')'){
                last_index=i+1;
                int repeat = st.pop();
                if(numbcheck){
                    String NumTrue="";
                    for(int k=0; k<repeat; k++){
                        NumTrue += tmp_s;
                    }
                    sb.append(NumTrue);

                }else{
                    String sb_tmp = sb.toString()+tmp_s;
                    sb=new StringBuilder();
                    for(int k=0; k<repeat; k++){
                        sb.append(sb_tmp);
                    }
                }
                if(st.isEmpty()){
                   q.add(sb.toString());
                   sb = new StringBuilder();
                }
                tmp_s="";
                numbcheck = false;
            }else{
                last_index=i+1;
                tmp_s=tmp_s+Character.toString(tmp);


            }

        }

    }




}
