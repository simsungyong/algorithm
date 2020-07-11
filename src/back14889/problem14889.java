package back14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem14889 {
    static int n;
    static int arr[][];
    static boolean check[];

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new boolean[n];

        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        choice(0,0);

        System.out.println(min);

    }
    public static void choice(int start, int teamN){
        if(teamN == n/2){
            min = Math.min(min,getMin());
            return;
        }

        for(int i=start; i<n; i++){
            if(!check[i]) {
                check[i] = true;
                choice(start + 1, teamN + 1);
                check[i] = false;
            }

        }
    }

    public static int getMin(){
        int startTeam=0;
        int linkTeam=0;
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(check[i] && check[k]){
                    startTeam += arr[i][k];
                }

                if(!check[i] && !check[k]){
                    linkTeam += arr[i][k];
                }
            }
        }
        return Math.abs(startTeam-linkTeam);
    }
}
//시간초과난다. 고쳐야됨