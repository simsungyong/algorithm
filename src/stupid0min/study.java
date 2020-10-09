package stupid0min;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class study {
    public static void main(String[] args) throws IOException {
        Node v = new Node();
        v.initial(5,9);
        v.sum();
    }
}

class Node {
    int x,y;
//    Node(int x, int y){
//        this.x=x;
//        this.y=y;
//    }

    public void initial(int x, int y){
        this.x = x;
        this.y=y;
    }
    public void sum(){
        System.out.println(x+y);
    }
}
