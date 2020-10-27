import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex {
    public static void main(String[] args) throws IOException {
        Node arr[] = new Node[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++){
            arr[i] = new Node(i,i+10,br.readLine());
        }

        Arrays.sort(arr);
        for(Node tmp: arr){
            System.out.println(tmp.name);
        }
    }
}

class Node implements Comparable<Node>{
    int rank, total;
    String name;
    Node(int rank, int total, String name){
        this.rank = rank;
        this.total = total;
        this.name = name;
    }
    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}
