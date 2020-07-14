package back1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1074 {
    static int arr[][];
    static int n,x,y;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int num = (int)Math.pow(2,n);
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        count = 0;

        move(0,0,num);

    }

    public static void move(int tmp_x, int tmp_y,int num){
        if(num==1){
            if(x==tmp_x && y==tmp_y){
                System.out.println(count);
            }

            count++;
            return;
        }

        num = num/2;
        move(tmp_x,tmp_y, num);
        move(tmp_x,tmp_y+num, num);
        move(tmp_x+num,tmp_y, num);
        move(tmp_x+num,tmp_y+num, num);


    }
}
//재귀하면서 순서 잘짜기