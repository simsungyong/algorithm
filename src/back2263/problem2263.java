package back2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem2263 {
    static int n;
    static int inorder[];
    static int postorder[];
    static HashMap<Integer, Integer> index = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            index.put(tmp,i);
            inorder[i] = tmp;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            postorder[i] = tmp;
        }

        search(0,n-1,0,n-1);
        System.out.println(sb.toString());

    }
    public static void search(int instart, int inend, int postart, int poend){

        if(instart > inend || postart > poend){
            return;
        }
        int root = postorder[poend];
        int rootindex = index.get(root);
        int left = rootindex - instart;
        sb.append(root+" ");

        search(instart, rootindex-1, postart, postart+left-1);

        search(rootindex+1,inend,postart+left, poend-1);

    }
}
