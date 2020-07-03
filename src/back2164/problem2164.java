package back2164;

import java.util.ArrayList;
import java.util.Scanner;

public class problem2164 {
    static ArrayList arr = new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            arr.add(i,i+1);
        }
        while(true){
            sol();
            if(arr.size() == 1){
                break;
            }else{
                continue;
            }

        }
        System.out.println(arr.get(0));
    }
    public static void sol(){
        arr.remove(0);
        int cnt =(int) arr.get(0);
        arr.remove(0);
        arr.add(arr.size(),cnt);
    }
}
