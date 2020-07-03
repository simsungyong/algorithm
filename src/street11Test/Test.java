package street11Test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        String ip_add [] = {"3.5.5.5","155.123.124.111","10.16.125.0","155.123.124.111","3.5.5.5","155.123.124.111","10.16.125.0","10.16.125.0","3.5.5.5","3.5.5.5"};
        String langs [] = {"Java", "C++", "Python3","C#","Java","C","Python3","JavaScript","Java","Java"};
        int scores [] = {294,197,373,45,294,62,373,373,294,294};
        int num= ip_add.length;
        List<String>[] arr = new ArrayList[ip_add.length];
        for(int i=0; i<ip_add.length; i++){
            for(int k=0; k<=i; k++){
                if(k == i){
                    arr[k] = new ArrayList<>();
                    arr[k].add(ip_add[i]);
                    if(langs[i].charAt(0) == 'C'){
                        arr[k].add("C");
                    }else{
                        arr[k].add(langs[i]);
                    }
                    arr[k].add(Integer.toString(scores[i]));
                }
                else {
                    if ( arr[k] != null && arr[k].get(0) == ip_add[i]) {
                        if(langs[i].charAt(0) == 'C'){
                            arr[k].add("C");
                        }else{
                            arr[k].add(langs[i]);
                        }
                        arr[k].add(Integer.toString(scores[i]));
                        break;
                    }
                }
            }
        }


        for(int i=0; i<arr.length; i++){
            if(arr[i]==null){
                break;
            }
            int tempnum = arr[i].size()/2;
            if(tempnum >=4){
                num = num-tempnum;
            }else{
                if(tempnum==2){
                    if(Integer.parseInt(arr[i].get(2)) == Integer.parseInt(arr[i].get(4))){
                        num = num- tempnum;
                    }
                }
                if(tempnum==3){
                    if((arr[i].get(1)== arr[i].get(3)) && (arr[i].get(1) == arr[i].get(5)) ){
                        num= num-tempnum;
                    }
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != null){
                for(int k=0; k<arr[i].size(); k++){
                    System.out.print(arr[i].get(k)+" ");
                }
                System.out.println();
            }
        }

        System.out.println(num);





    }

}
