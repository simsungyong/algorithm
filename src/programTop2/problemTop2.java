package programTop2;

import java.util.LinkedList;
import java.util.Queue;

public class problemTop2 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int truck_weights [] = {7,4,5,6};
        System.out.print(solution(bridge_length,weight,truck_weights));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> onbridge = new LinkedList<>();
        for(int w : truck_weights){
            waiting.offer(new Truck(w,0));
        }

        int time=0;
        int totalweight=0;
        while(!waiting.isEmpty() || !onbridge.isEmpty()){
            time++;
            if(!onbridge.isEmpty()){
                Truck t = onbridge.peek();
                if(time-t.startTime >= bridge_length){
                    totalweight-=t.weight;
                    onbridge.poll();
                }
            }

            if(!waiting.isEmpty()){
                if(weight >= totalweight + waiting.peek().weight){
                    Truck t = waiting.poll();
                    totalweight += t.weight;
                    onbridge.offer(new Truck(t.weight , time ));

                }
            }

        }


        return time;
    }


    static class Truck {
        int weight;
        int startTime;
        Truck(int weight, int startTime){
            this.weight = weight;
            this.startTime = startTime;
        }
    }
}
