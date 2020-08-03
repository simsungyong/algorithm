package tossTest04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class problem04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String next = st.nextToken();
            arr.add(next);
            current_back(arr);
            System.out.println();
        }
    }

    public static void current_back(ArrayList<String> cnt){
        Stack<String> nowStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(String tmp : cnt){
            nowStack.push(tmp);
        }

        Set<String> set = new HashSet<>();
        int num=0;

        while(nowStack.size()>0){

            if(num==5){
                break;
            }
            if(!set.contains(nowStack.peek())){
                String now = nowStack.pop();
                System.out.print(now+" ");
                set.add(now);
                num++;
            }else{
                nowStack.pop();
            }



        }

    }
}
