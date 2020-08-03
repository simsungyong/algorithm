package tossTest05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arrKim [] = br.readLine().split(" ");
        String arrLee [] = br.readLine().split(" ");
        int aftercal = 0;
        for(int i=0; i<arrKim.length ; i++){
            if(Integer.parseInt( arrKim[i]) - Integer.parseInt( arrLee[i]) > 0){
                if(Integer.parseInt( arrKim[i]) - Integer.parseInt( arrLee[i])+aftercal > 0){
                    System.out.print(Integer.parseInt( arrKim[i]) - Integer.parseInt( arrLee[i])+aftercal+" ");
                    aftercal = 0;
                }else{
                    aftercal +=Integer.parseInt( arrKim[i]) - Integer.parseInt( arrLee[i]);
                    System.out.print(0+" ");
                }
            }else{
                aftercal += (Integer.parseInt( arrKim[i]) - Integer.parseInt( arrLee[i]));
                System.out.print(0+" ");

            }
        }

    }

}
