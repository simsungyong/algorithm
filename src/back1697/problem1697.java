package back1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1697 {
    static int n,k;
    static int minarr[];
    static int kind[] = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        minarr = new int [Math.max(n,k)*2+1];

        bfs();
        System.out.println(minarr[k]);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(minarr, Integer.MAX_VALUE);
        q.add(n);
        minarr[n]=0;

        while(!q.isEmpty()){
            int tmp = q.poll();

            if(tmp == k ){
               continue;
            }

            if(tmp > k){
                if(minarr[tmp-1] > minarr[tmp]+1){
                    minarr[tmp-1] =  minarr[tmp]+1;
                    q.add(tmp-1);
                }
            }
            else{
                for(int i=0; i<2; i++){
                    int next = tmp+kind[i];
                    if(next >=0){


                        if(minarr[next] > minarr[tmp]+1){
                            minarr[next] = minarr[tmp]+1;
                            q.add(next);
                        }
                    }
                }
                int mul=tmp*2;
                if(minarr[mul] > minarr[tmp]+1){
                    minarr[mul] = minarr[tmp]+1;
                    q.add(mul);
                }
            }



        }
    }
}

