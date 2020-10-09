package stupid0min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Study4 {

    static int a,b,answer;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        sum();

        System.out.println(answer);


    }

    public static void sum(){

        answer = a+b;

    }
}
