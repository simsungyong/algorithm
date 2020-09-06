package kongHard;

import java.util.HashSet;
import java.util.Set;

public class problem3 {
    public static void main(String[] args) {
        System.out.println(func(4));
    }

    public static boolean func(int input){
        if(input==1){
            return true;
        }

        Set<Integer> set = new HashSet<>();
        String temp = String.valueOf(input);
        boolean isOne = true;
        set.add(input);

        while(Integer.parseInt(temp) != 1){
            int sum = 0;
            for(int i=0; i<temp.length();i++){
                sum+=Integer.parseInt(temp.substring(i,i+1))*Integer.parseInt(temp.substring(i,i+1));
            }
            if(set.contains(sum)){
                isOne = false;
                break;
            }else{
                set.add(sum);
            }

            temp = String.valueOf(sum);
        }

        return isOne;

    }
}
