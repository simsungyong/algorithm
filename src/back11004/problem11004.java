package back11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem11004 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        StringTokenizer a = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(a.nextToken());
        }

        quickSort(arr,0,n-1);
        System.out.println(arr[k-1]);

    }
    public static int partition(int arr [], int left, int right){
        int pivot = arr[(left+right)/2];
        while(left<right){
            while ((arr[left] < pivot) && (left < right)) left++;
            while ((arr[right] > pivot) && (left < right)) right --;

            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return left;
    }

    public static void quickSort(int arr[] ,int left ,int right){
        if(left<right){
            int pivotNewIndex = partition(arr,left, right);
            quickSort(arr,left,pivotNewIndex-1);
            quickSort(arr,pivotNewIndex+1, right);
        }
    }
}
//퀵소트!