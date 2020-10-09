package back2493;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;
        import java.util.StringTokenizer;

public class problem2493 {
    static int n;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack  = new Stack<>();

        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i]=temp;
        }

        stack.push(new Node(arr[n-1],n-1));

        for(int i=n-2; i>=0; i--){
            int wall = arr[i];
            while(!stack.isEmpty()){
                if(stack.peek().h<=wall){
                    arr[stack.pop().i] = i+1;
                }else{
                    break;
                }
            }
            stack.push(new Node(wall,i));
        }

        while(!stack.isEmpty()){
            arr[stack.pop().i] = 0;
        }


        for(int a : arr){
            System.out.print(a+" ");
        }


    }
}
class Node {
    int h,i;
    Node(int h, int i){
        this.h=h;
        this.i=i;
    }
}