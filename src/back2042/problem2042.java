package back2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2042 {
    static long arrsum[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
        arr = new int[n];
        arrsum = new long[4*n];

        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        init(1,0,n-1);


        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type==1){
                int diff = b-arr[a-1];
                arr[a-1] = b;
                update(1,0,n-1,a-1,diff);
            }else{
                sb.append(sum(1,0,n-1,a-1,b-1)+"\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static long sum(int node, int start, int end, int left, int right){

        if(right < start || left > end){
            return 0;
        }

        if(right >= end && left <= start){
            return arrsum[node];
        }

        int mid = (start+end)/2;
        return sum(node*2, start, mid, left, right)+ sum(node*2+1, mid+1, end, left, right);
    }

    public static void update(int node, int start, int end, int index, int diff){
        if(!(start <= index && end >= index)){
            return;
        }

        arrsum[node]+=diff;
        if(start!=end){
            int mid = (start+end)/2;
            update(node*2, start,mid, index, diff);
            update(node*2+1, mid+1,end, index,diff);
        }
    }

    public static long init(int node, int start, int end){
        if(start==end)
            return arrsum[node] = arr[start];

        int mid = (start+end)/2;
        return arrsum[node] = init(node*2,start, mid)+init(node*2+1,mid+1, end);
    }
}
