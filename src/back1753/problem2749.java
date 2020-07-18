package back1753;

import java.util.Scanner;

public class problem2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int pisano = 1500000;
        long fibo[] = new long [pisano];
        fibo[0]=0;
        fibo[1] =1;

        for(int i=2; i<pisano && i<=n; i++){
            fibo[i]  = (fibo[i-2]+fibo[i-1])%1000000;
        }
        if(n >=pisano){
            n %= pisano;
        }

        System.out.println(fibo[(int) n]);

    }
}
//피사노 주기!!!! 알아둘것 나누는수가 10^k 일때 주기는 15*10^(k-1)