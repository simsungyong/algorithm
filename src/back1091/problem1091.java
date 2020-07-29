package back1091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1091 {
    static int n;
    static int p[];
    static int s[];
    static int temp[];
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        s = new int[n];
        temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < n; k++) {
            temp[k] =k;
            p[k] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < n; k++) {
            s[k] = Integer.parseInt(st.nextToken());
        }

        while(true){
            boolean isNext = false;
            for(int i=0; i<n; i++){
                if((i%3) != p[temp[i]]){
                    isNext = true;
                    break;
                }
            }

            if(isNext){
                answer++;
                temp = change();

                if(!continueCheck(temp)){
                    System.out.println(-1);
                    break;
                }

            }else{
                System.out.println(answer);
                break;
            }


        }
    }
    public static int[] change(){
        int cnt[] = new int[n];
        for(int i=0; i<n; i++){
            cnt[s[i]] = temp[i];
        }


        return cnt;
    }

    public static boolean continueCheck(int [] temp){
        boolean check = false;
        for(int i=0; i<n; i++){
            if(temp[i]!=i){
                check = true;
                break;
            }
        }
        return check;
    }
}
