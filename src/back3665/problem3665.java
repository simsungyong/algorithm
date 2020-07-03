package back3665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<testCase; i++){
            int flag = 1;
            int n = Integer.parseInt(br.readLine());
            int arr [] = new int[n+1];

            int input [] = new int [n+1];
            st = new StringTokenizer(br.readLine());
            for(int k =1; k<=n; k++){
                input[k] = Integer.parseInt(st.nextToken());
            }
            boolean map [][] = new boolean [n+1][n+1];
            for(int k=1; k<n; k++){
                for(int l=k+1; l<=n; l++){
                    map[input[k]][input[l]]=true;
                }
            }

            int change = Integer.parseInt(br.readLine());

            for(int k=0; k<change; k++){
                st = new StringTokenizer(br.readLine());
                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                map[temp1][temp2] = !map[temp1][temp2];
                map[temp2][temp1] = !map[temp2][temp1];
            }

        for(int k=1; k<=n; k++){
                int cnt = 0;
            for(int l=1; l<=n; l++){
                if(map[k][l]==true){
                    cnt++;
                }
            }
            if(arr[n-cnt] == 0 ){
                arr[n-cnt] = k;
            }else{
                flag = 0;
                break;
            }

        }
        if(flag == 1){
            for(int k=1; k<=n; k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }else{
                System.out.println("IMPOSSIBLE");
        }

        }

    }
}
