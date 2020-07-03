package back.back13199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem13199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc <TC; tc ++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] input = new int[4];
            for(int i=0; i<4; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            int sum_A = input[1]/input[0]+input[3]*(input[1]/input[0])/input[2];

            int sum_B = input[1]/input[0];
            int remain_coupon_B = ((input[1]/input[0])*input[3]-input[2]) >= 0 ? (input[1]/input[0])*input[3]-input[2]:(input[1]/input[0])*input[3] ;
            sum_B = sum_B+1+remain_coupon_B/(input[2]-input[3]);

            System.out.println(sum_B);

        }

    }

}
/*한마리 빼놓고 필요한쿠폰-받는쿠폰으로 나누면됨*/

