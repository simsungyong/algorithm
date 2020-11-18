package stupid0min.sorting;

public class Quick {
    public static void main(String[] args) {
        int arr [] = {7,6,11,3,13,20,1,5};
        sort(arr, 0, arr.length - 1);
        for(int a : arr){
            System.out.print(a+" ");
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//쿽 정렬의 성능은 어떻게 pivot 값을 선택 선택하느냐에 크게 달라질 수 있다. 이상적인 경우에는 pivot 값을 기준으로 동일한 개수의 작은 값들과 큰 값들이 분할되어 병합 정렬과 마찬가지로 O(NlogN)의 시간 복잡도를 가지게 된다.
//하지만 pivot 값을 기준으로 분할했을 때 값들이 한 편으로 크게 치우치게 되면, 퀵 정렬은 성능은 저하되게 되며, 최악의 경우 한 편으로만 모든 값이 몰리게 되어 O(N^2)의 시간 복잡도가 나온다.
