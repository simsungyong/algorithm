package back5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem5639 {
    static  StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        Tree tree = new Tree(Integer.parseInt(br.readLine()));
        String s="";
        while ((s = br.readLine()) != null && s.length() != 0) {
            tree = tree.addTree(tree, Integer.parseInt(s));
        }
        postorder(tree);
        System.out.println(sb.toString());

    }
    public static void postorder(Tree tree){
        if(tree.left != null){
            postorder(tree.left);
        }
        if(tree.right != null){
            postorder(tree.right);
        }
        sb.append(tree.value+"\n");

    }
}

class Tree {
    int value;
    Tree left;
    Tree right;
    Tree(int value){
        this.value=value;
        this.left = null;
        this.right = null;
    }

    Tree addTree(Tree tree, int value){
        Tree cnt = null;
        if (tree == null) return new Tree(value);
        if(tree.value > value){
            cnt = addTree(tree.left, value);
            tree.left = cnt;
        }else if(tree.value < value){
            cnt = addTree(tree.right, value);
            tree.right = cnt;
        }

        return tree;
    }
}//트리 구조 구성하는거 익숙해지기.

