package programmers_disk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Prior> q = new PriorityQueue<>();
        List<Prior> l = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            q.add(new Prior(jobs[i][0], jobs[i][1]));
        }
        for (int i = 0; i < jobs.length; i++) {
            l.add(q.poll());
        }

        int currentTime = 0;
        int sumTime = 0;
        while (!l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {
                if (currentTime >= l.get(i).startTime) {
                    currentTime += l.get(i).duringTime;
                    sumTime += currentTime-l.get(i).startTime;
                    l.remove(i);
                    break;
                }
                if (i == l.size() - 1) {
                    currentTime++;
                }
            }
        }
        int answer = 0;
        answer = (sumTime / jobs.length);
        return answer;
    }
}


public class Prior implements Comparable<Prior>{
    int startTime;
    int duringTime;
    public Prior(int startTime, int duringTime){
        this.startTime = startTime;
        this.duringTime = duringTime;
    }

    @Override
    public int compareTo(Prior o) {
        if(this.duringTime < o.duringTime) return -1;

        if(this.duringTime == o.duringTime){
            if(this.startTime < o.startTime){
                return -1;
            }else{
                return 0;
            }
        }else {
            return 0;
        }
    }


}


