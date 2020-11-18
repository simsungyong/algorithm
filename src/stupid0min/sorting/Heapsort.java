package stupid0min.sorting;

public class Heapsort {
    public static void main(String[] args) {
        int arr[] = {6,4,2,3,9,10,5,8,7,1};

        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr,arr.length,i);
        }

        for(int i=arr.length-1; i>=0; i--){
            swap(arr,i,0);
            heapify(arr,i-1,0);
        }


        for(int a : arr){
            System.out.print(a+" ");
        }
    }

    public static void heapify(int arr[], int size, int pNode){
        int parent = pNode;
        int left = pNode*2+1;
        int right = pNode*2+2;

        if(size > left && arr[left] > arr[parent]){
            parent = left;
        }

        if(size > right && arr[right] > arr[parent]){
            parent = right;
        }

        if(parent != pNode){
            swap(arr,pNode,parent);
            heapify(arr,size,parent);
        }
    }

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
