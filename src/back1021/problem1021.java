package back1021;

import java.util.ArrayList;
import java.util.Scanner;

public class problem1021 {
    static ArrayList arr = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++){
            arr.add(i,i+1);
        }


        int answer = 0;
        for(int i=0; i<target; i++){
            int cnt = sc.nextInt();
            answer = answer+move(cnt);
        }

        System.out.println(answer);


    }

    public static int move(int target){
        int num=0;
        while(true){
            int cnt = (int)arr.get(0);
            if(cnt == target){
                num = Math.min(num,arr.size()-num);
                arr.remove(0);
                break;
            }else{
                arr.remove(0);
                arr.add(arr.size(),cnt);
                num++;
            }

        }

        return num;
    }
}
