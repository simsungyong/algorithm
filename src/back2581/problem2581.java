package back2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        boolean check [] = new boolean[10001];
        check[1] = true;
        int total = 0;
        int min=0;
        for(int i=2 ; i<=end; i++){
            if(!check[i]){
                int index=0;
                while((i*i+i*index)<=end ){
                    check[i*i+i*index] = true;
                    index++;
                }
            }
        }

        for(int i=start; i<=end; i++){
            if(min==0 && !check[i]){
                min=i;
                total += i;
            }
            else if(!check[i]){
                total+=i;
            }
        }

        if(min==0){
            System.out.println(-1);
        }else{
            System.out.println(total);
            System.out.println(min);
        }
    }
}
