package back4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class problem4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        Node arr[];
        double size=0;
        String input;
        while((input=br.readLine())!=null && input.length()!=0) {
            size++;
            if(map.containsKey(input)){
                map.replace(input, map.get(input)+1);
            }else{
                map.put(input,1);
            }
        }

        arr = new Node[map.size()];
        Iterator<String> iteratorK = map.keySet().iterator();
        int index=0;
        while(iteratorK.hasNext()){
            String name = iteratorK.next();
            double value = 100*(double)map.get(name)/size;
            String num = String.format("%.4f", value);
            arr[index] = new Node(name,num);
            index++;
        }
        Arrays.sort(arr);
        for(Node tmp: arr){
            System.out.println(tmp.name+" "+tmp.v);
        }

    }


}
class Node implements Comparable<Node>{
    String name;
    String v;
    Node(String name, String v){
        this.name = name;
        this.v=v;
    }

    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}
