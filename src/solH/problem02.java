package solH;

import java.util.HashSet;
import java.util.Set;

public class problem02 {
    static int parents[];
    public static void main(String[] args) {
        int arr[][] = {{1,2},{2,4}};
        solution(10,arr);
    }
    public static int solution(int V, int arr[][]){
        int answer=0;
        Set<Integer> set = new HashSet<>();
        parents= new int[V+1];
        for(int i =1; i<=V ; i++){
            parents[i]=i;
        }

        for(int i=0; i<arr.length; i++){
            union(arr[i][0], arr[i][1]);
        }

        for(int i=1; i<=V; i++){
            if(!set.contains(parents[i])){
                set.add(parents[i]);
                answer++;
            }
        }
        System.out.println(answer-1);
        return answer-1;
    }

    public static int find(int index){
        if(index==parents[index]){
            return index;
        }else{
            return parents[index] = find(parents[index]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            if(a>b){
                parents[a] = b;
            }else{
                parents[b]=a;
            }

        }
    }

}
