package back2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2437 {
    static int n;
    static int arr[];
//    static int arrcheck[];
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(cnt < arr[i]){
                break;
            }else{
                cnt += arr[i];
            }
        }

        System.out.println(cnt);

    }

}


//생각하기 어렵다. 이때까지 더한 sum이 의미하는 바는 => 0~sum까지는 다 만들수있다는말이다.