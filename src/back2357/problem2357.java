package back2357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2357 {
    static int m,n;
    static int arr[];
    static long treemin[];
    static long treemax[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        treemin = new long[4*n];
        treemax = new long[4*n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        initmin(1,0,n-1);
        initmax(1,0,n-1);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(findmin(1, 0, n-1, start-1, end-1)+" "+findmax(1, 0, n-1, start-1, end-1));
        }
    }

    public static long findmin(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return Integer.MAX_VALUE;
        }

        if(left <=start && right >= end){
            return treemin[node];
        }

        int mid = (start+end)/2;
        return Math.min(findmin(node*2, start, mid, left, right), findmin(node*2+1, mid+1, end, left, right));

    }

    public static long findmax(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return Integer.MIN_VALUE;

        }

        if(left <=start && right >= end){
            return treemax[node];
        }

        int mid = (start+end)/2;
        return Math.max(findmax(node*2, start, mid, left, right), findmax(node*2+1, mid+1, end, left, right));

    }


    public static long initmin(int node, int start, int end) {
        if(start==end)
            return treemin[node] = arr[start];

        int mid=(start+end)/2;
        return treemin[node]=Math.min(initmin(node*2,start,mid), initmin(node*2+1,mid+1,end)); //가장 값을 넣어야 하므로, 가장 작은 값으로 갱신해 준다.
    }

    public static long initmax(int node, int start, int end) {
        if(start==end)
            return treemax[node] = arr[start];

        int mid=(start+end)/2;
        return treemax[node]=Math.max(initmax(node*2,start,mid), initmax(node*2+1,mid+1,end)); //가장 값을 넣어야 하므로, 가장 작은 값으로 갱신해 준다.
    }
}
