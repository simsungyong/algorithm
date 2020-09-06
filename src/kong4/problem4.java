package kong4;

import java.util.Arrays;

public class problem4 {
    public static void main(String[] args) {
        int input[]={2,8,32,12,5,1,65,324,11,9,92,78,54,55,222,110,114,432};
        int ans[] = func(input,101);
        System.out.println(ans[0]+" "+ans[1]);

    }
    public static int[] func(int input[], int target){
        Node arr[] = new Node[input.length];
        int answer[] = new int[2];
        for(int i=0; i<input.length;i++){
            arr[i] = new Node(i,input[i]);
        }

        Arrays.sort(arr);

        for(int i=0; i<input.length-1;i++){
            for(int k=i+1; k<input.length; k++){
                if(arr[i].value+arr[k].value==target){
                    answer[0] = arr[i].index;
                    answer[1]= arr[k].index;
                }else if(arr[i].value+arr[k].value > target){
                    break;
                }
            }
        }

        return answer;
    }
}
class Node implements Comparable<Node>{
    int index,value;
    Node(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
