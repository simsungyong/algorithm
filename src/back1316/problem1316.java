package back1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num=0;
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            boolean check [] = new boolean[26];
            for(int k=0; k<temp.length(); k++){

                if(check[temp.charAt(k)-'a']){
                    break;
                }else{
                    if(k==temp.length()-1){
                        num++;
                        break;
                    }
                    if(k<temp.length()-1 && temp.charAt(k+1) != temp.charAt(k)){
                        check[temp.charAt(k)-'a'] = true;
                    }
                }
            }

        }
        System.out.print(num);

    }
}
