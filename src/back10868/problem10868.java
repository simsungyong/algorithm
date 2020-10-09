package back10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10868 {
    static int m,n;
    static int arr[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tree = new long[4*n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1,0,n-1);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(find(1, 0, n-1, start-1, end-1));
        }

    }

    public static long find(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return Integer.MAX_VALUE;
        }

        if(left <=start && right >= end){
            return tree[node];
        }

        int mid = (start+end)/2;
        return Math.min(find(node*2, start, mid, left, right), find(node*2+1, mid+1, end, left, right));

    }

    public static long init(int node, int start, int end) {
        if(start==end)
            return tree[node] = arr[start];

        int mid=(start+end)/2;
        return tree[node]=Math.min(init(node*2,start,mid), init(node*2+1,mid+1,end)); //가장 값을 넣어야 하므로, 가장 작은 값으로 갱신해 준다.
    }
}
