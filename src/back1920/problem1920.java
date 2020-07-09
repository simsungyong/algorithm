package back1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem1920 {
    static int list[];
    static int n;
    public static void main(String[] args) throws IOException {
//        HashSet<Integer> set = new HashSet<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for(int i=0; i<n; i++){
//            int cnt = Integer.parseInt(st.nextToken());
//            set.add(cnt);
//        }
//        int m = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<m; i++){
//            int cnt = Integer.parseInt(st.nextToken());
//            if(set.contains(cnt)){
//                System.out.println(1);
//            }else{
//                System.out.println(0);
//            }
//        }   hashset 이용한것. 이 코드도 시간초과 안뜨긴한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n];
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(st.nextToken());
            list[i] = cnt;
        }

        Arrays.sort(list);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int cnt = Integer.parseInt(st.nextToken());
            search(cnt);
        }
    }
    public static void search(int k){
        int answer=0;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(k>=list[mid]){
                if(k==list[mid]){
                    answer=1;
                    break;
                }
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(answer);


    }
}