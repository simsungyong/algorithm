package back15651;

import java.io.*;
import java.util.StringTokenizer;

public class problem15651 {
        static int N, num;
        static int list[];
        static boolean check[];
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            list= new int [num];
            check = new boolean[N+1];
            backtrack(0);

        }
        public static void backtrack(int n) throws IOException {
            if(num==n){
                for(int a : list){
                    bw.write(Integer.toString(a)+" ");
                }
                bw.newLine();
                bw.flush();
                return;
            }

            for(int i=1; i<=N; i++){
                    list[n] = i;
                    backtrack(n+1);
                    list[n] = 0;
                }
            }
}

//Bufferwriter쓰면 시간초과안남. println쓰면 너무 심함.
