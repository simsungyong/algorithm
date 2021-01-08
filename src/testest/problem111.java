package testest;

import java.util.*;

public class problem111 {
    static int answer=Integer.MAX_VALUE;
    static boolean check[];

    public static void main(String[] args) {
        String a[] = {"[404]James","[405]andy,yong,sun","[235]sim,hae,jun"};

        sol(a,308);
    }

    public static void sol(String a[], int target){
        HashMap<String, Integer> namenum = new HashMap<>();
        HashMap<String, Integer> nameroom = new HashMap<>();
        Set<String> except = new HashSet<>();

        for(int i=0; i<a.length; i++){

            String num = a[i].split("]")[0];
            int room = Integer.parseInt(num.substring(1,num.length()));


            String namearr []= a[i].split("]")[1].split(",");

            if(room==target){
                for(int k=0; k<namearr.length; i++){
                    except.add(namearr[k]);
                }
            }else{
                for(int k=0; k<namearr.length; i++){
                    if(namenum.containsKey(namearr[k])){
                        namenum.put(namearr[k],namenum.get(namearr[k])+1);
                    }else{
                        namenum.put(namearr[k],1);
                    }
                    if(nameroom.containsKey(namearr[k])){
                        if(Math.abs(target-room) < Math.abs(nameroom.get(namearr[k])-target)){
                            nameroom.put(namearr[k], room);
                        }
                    }else{
                        nameroom.put(namearr[k],room);
                    }
                }
            }
        }


    }


}

class Node implements Comparable<Node>{
    String name;
    int room,num,target;

    Node(String name, int room, int num){
        this.name = name;
        this.room = room;
        this.num = num;
    }
    @Override
    public int compareTo(Node o) {
        if(this.num<o.num){
            return -1;
        }else if(this.num==o.num){
            if(Math.abs(this.target-this.room) < Math.abs(o.target-o.room)){
                return -1;
            }else{
                return 1;
            }
        }
        else return 1;
    }
}
