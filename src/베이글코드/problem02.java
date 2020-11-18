package 베이글코드;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class problem02 {
    public static void main(String[] args) {
        int arr[][]= {{1,2},{2,3},{3,4}, {4,5},{1,6},{6,7}};
        String name[] = {"root","a","b","c","d","efghij","k"};
        System.out.println(solution(7,arr,name));
    }

    public static int solution(int N, int[][] relation, String[] dirname) {
        int answer;
        ArrayList<Integer> arr[] = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<relation.length; i++){
            arr[relation[i][0]].add(relation[i][1]);
        }

        answer = bfs(arr, dirname);


        return answer;
    }

    public static int bfs(ArrayList<Integer> arr[], String[] dirname){
        PriorityQueue<Node> q = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        q.add(new Node(1,dirname[0].length(),0));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            max = Math.max(max, tmp.length+tmp.height);
            for(int i=0; i<arr[tmp.index].size(); i++){
                int next = arr[tmp.index].get(i);
                q.add(new Node(next,tmp.length+dirname[next-1].length(), tmp.height+1));
            }
        }

        return max;

    }

//    public static void dfs(int cntsum, int index, int height, ArrayList<Integer> arr[], String[] dirname){
//        if(arr[index].size()==0){
//            max = Math.max(max, cntsum+height);
//            return;
//        }
//
//        for(int i=0; i<arr[index].size(); i++){
//            dfs(cntsum+dirname[arr[index].get(i)-1].length(), arr[index].get(i), height+1, arr,dirname);
//        }
//
//    }
}
class Node implements Comparable<Node>{
    int index, length, height;
    Node(int index, int length, int height){
        this.index = index;
        this.height = height;
        this.length = length;
    }


    @Override
    public int compareTo(Node o) {
        return o.length - this.length;
    }
}