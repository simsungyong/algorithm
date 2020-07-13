package back1027;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1027 {
    static int list[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max=0;

        for(int i=0; i<n;i++){
            max = Math.max(max, cal(i));

        }
        System.out.println(max);


    }

    public static int cal(int index){
        int num=0;

        for(int i=0; i<n; i++){
            boolean canSee = true;
            if(index==i){
                continue;
            }
            int small = i< index ? i : index;
            int big = i<index ? index : i;

            if(Math.abs(small-big)==1){
                num++;
                continue;
            }


            for(int k = small+1; k<big; k++){
                double y;
                if(k<index){
                    y = list[index]+(double)(k-big)*(list[big]-list[small])/(big-small);
                }else{
                    y = list[index]+(double)(k-small)*(list[big]-list[small])/(big-small);

                }

                if(list[k] >= y) {
                    canSee = false;
                    break;
                }
            }
            if(canSee){
                num++;
            }
        }
        return num;

    }
}
//방정식써서 품. N=50이하라서 포문 신경안써도된다