package back2568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2568 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        Node input[] = new Node[n];
        Node indexarr[] = new Node[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(input);


        for(int i=0; i<n; i++){
            if(list.size()==0 || list.get(list.size()-1) < input[i].value){
                list.add(input[i].value);
                indexarr[i] = new Node(input[i].index, list.size()-1);
            }else{
                int left =0;
                int right = list.size()-1;

                while(left<right){
                    int mid = (left+right)/2;
                    if(list.get(mid) < input[i].value){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }

                list.set(right,input[i].value);
                indexarr[i] = new Node(input[i].index,right);
            }
        }


        int size = list.size()-1;
        for(int i=n-1; i>=0; i--){
            if(indexarr[i].value == size){
                size--;
            }else{
                sb.append(input[i].index+" ");
            }
        }

        System.out.println(n-list.size());
        String answer[] = sb.toString().split(" ");
        for(int i=answer.length-1; i>=0; i--){
            System.out.println(answer[i]);
        }

    }
}
class Node implements Comparable<Node>{
    int index,value;
    Node(int index, int value){
        this.index= index;
        this.value = value;
    }
    @Override
    public int compareTo(Node o) {
        return this.index-o.index;
    }
}