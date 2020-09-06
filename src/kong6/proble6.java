package kong6;

import java.util.Arrays;

public class proble6 {
    public static void main(String[] args) {
        int arr1[]= {1,3,5,6,14,15,0,0,0,0,0};
        int arr2[] ={2,7,8,12,18};
        int m = 6;
        int n=5;
        func(arr1,m,arr2,n);
    }
    public static void func(int nums1[], int m, int nums2[], int n){
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);

    }
}
