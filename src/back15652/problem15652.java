package back15652;

import java.io.*;
import java.util.StringTokenizer;


public class problem15652 {
    static int N,num;
    static int list[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        list= new int [num];

        backtrack(0,1);
    }
    public static void backtrack(int n, int cnt) throws IOException {
        if(num==n){
            for(int a : list){
                bw.write(Integer.toString(a)+" ");
            }
            bw.newLine();
            bw.flush();
            return;
        }

        for(int i=cnt; i<=N; i++){
            list[n] = i;
            backtrack(n+1,i);
            list[n] = 0;
        }
    }

}
