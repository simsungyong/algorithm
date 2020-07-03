package testKB;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class testKB {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        float goalheight = scanner.nextFloat();
        float firstHeight = scanner.nextFloat();
        float down = scanner.nextFloat();
        float percent = scanner.nextFloat();
        float gap = firstHeight*percent/100;
        float b1 = firstHeight*(1-(percent/100)) - down;
        int num = 0;





        while(true){
            num ++;
            double temp = firstHeight+b1*(num-1)+(num-1)/2 - num*(num-1)/2*gap;
            if(temp > goalheight){
                System.out.print("Success "+num);
                break;
            }

            if(temp-down < 0 ){
                System.out.print("Failure "+num);

                break;
            }

        }






    }
}