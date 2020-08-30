package 어피치;

import java.util.*;

public class problem {
    public static void main(String[] args) {
        String arr[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int answer [] = solution(arr);
        System.out.print(answer[0]+" "+answer[1]);
    }
    public static int[] solution(String[] gems) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] answer = new int[2];
        Set<String> set;
        set = new HashSet(Arrays.asList(gems));

        int size = set.size();
        int length=Integer.MAX_VALUE;
        for(int i=0; i<=gems.length-size; i++){
            int next=i-1;
            boolean isComplete = true;
            while(!set.isEmpty()){
                next++;
                if(next==gems.length){
                    isComplete = false;
                    break;
                }
                if(next <= gems.length-1 &&set.contains(gems[next])){
                    set.remove(gems[next]);
                }
            }

            if(isComplete && length >= (next-i+1)){
                length = next-i+1;
                q.add(new Node(i,next));
            }

            set = new HashSet(Arrays.asList(gems));

        }

        Node answerNode = q.poll();
        answer[0] = answerNode.start;
        answer[1]= answerNode.end;

        return answer;
    }

}
class Node implements Comparable<Node>{
    int start,end;
    Node(int start, int end){
        this.start = start;
        this.end= end;
    }
    @Override
    public int compareTo(Node o) {

        return o.start-this.start;
    }
}
