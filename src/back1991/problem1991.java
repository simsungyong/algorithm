package back1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1991 {
    static int n;
    static char map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[26][2];
        for(int i=0 ; i<n; i++){
            char arr[] = br.readLine().replaceAll(" ","").toCharArray();
            map[arr[0]-'A'][0] = arr[1];
            map[arr[0]-'A'][1] = arr[2];
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');




    }
    public static void preorder(char v){
        System.out.print(v);
        if(map[v-'A'][0] != '.'){
            preorder(map[v-'A'][0]);
        }
        if(map[v-'A'][1] != '.'){

            preorder(map[v-'A'][1]);
        }
    }
    public static void inorder(char v){
        if(map[v-'A'][0]!= '.'){
            inorder(map[v-'A'][0]);
        }
        System.out.print(v);

        if(map[v-'A'][1]!= '.'){
            inorder(map[v-'A'][1]);
        }

    }
    public static void postorder(char v){

        if(map[v-'A'][0]!= '.'){
            postorder(map[v-'A'][0]);
        }

        if(map[v-'A'][1]!= '.'){
            postorder(map[v-'A'][1]);
        }
        System.out.print(v);

    }
}



