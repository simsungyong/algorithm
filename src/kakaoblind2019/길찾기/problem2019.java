package kakaoblind2019.길찾기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class problem2019 {
    static Queue<Integer> list;
    public static void main(String[] args) {
       int input [][]= {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
       solution(input);

    }
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        list = new LinkedList<>();
        Node arr[] = new Node[nodeinfo.length];
        for(int i=0; i< nodeinfo.length; i++){
            arr[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }
        Arrays.sort(arr,new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                return o1.y==o2.y ? o1.x-o2.x : o2.y-o1.y;
            }
        });

        Node root = arr[0];
        for(int i=1; i<nodeinfo.length; i++){
            makeTree(root, arr[i]);
        }

        preorder(root);
        for(int i=0; i<nodeinfo.length; i++){
            answer[0][i] = list.poll();
        }
        System.out.println();
        postorder(root);
        for(int i=0; i<nodeinfo.length; i++){
            answer[1][i] = list.poll();

        }







        return answer;
    }

    public static void makeTree(Node rt, Node tmp){
        if(rt.x<tmp.x){
            if(rt.right!=null){
                makeTree(rt.right,tmp);
            }else{
                rt.right = tmp;
            }
        }else{
            if(rt.left!=null){
                makeTree(rt.left,tmp);
            }else{
                rt.left = tmp;
            }
        }
    }


    public static void preorder(Node tmp){
        list.add(tmp.value);
        if(tmp.left!=null){
            preorder(tmp.left);
        }

        if(tmp.right!=null){
            preorder(tmp.right);
        }

    }

    public static void postorder(Node tmp){
        if(tmp.left!=null){
            postorder(tmp.left);
        }
        if(tmp.right!=null){
            postorder(tmp.right);
        }
        list.add(tmp.value);

    }




}
class Node{
    int value;
    int x,y;
    Node right=null;
    Node left=null;
    Node(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value = value;
    }
}
