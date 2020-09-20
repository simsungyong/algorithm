package back1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1766 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Node> q = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int info = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];
        for(int i=0; i<info; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        for(int i=1; i<=n; i++){
            if(arr[i]!=0){
                q.add(new Node(i,arr[i]));
            }else{
                q.add(new Node(i,i));
            }
        }

        while(!q.isEmpty()){
            System.out.println(q.poll().value);
        }
    }
}

class Node implements Comparator<Node> {
    int value, comp;
    Node(int value, int comp ){
        this.value = value;
        this.comp = comp;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if(o2.comp!=o2.value){
            return o2.value-o1.value;
        }else{
            return Integer.compare(o1.value, o2.value);
        }
    }
}
