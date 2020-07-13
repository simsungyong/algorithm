package back1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import java.util.StringTokenizer;

public class problem1043 {
    static HashSet<Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(st.nextToken());
        int answer=m;
        st = new StringTokenizer(br.readLine());
        int knowPeople = Integer.parseInt(st.nextToken());
        if(knowPeople!=0){
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                map.add(a);
            }
        }


        for(int i=0; i<m; i++){
            String tmp[] = br.readLine().split(" ");
            int num = Integer.parseInt(tmp[0]);

            for(int k=1; k<=num; k++){
                if(map.contains(Integer.parseInt(tmp[k]))){
                    checking(tmp,num);
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
    public static void checking(String arr[], int num){
        for(int i=1; i<=num; i++){
            if(!map.contains(Integer.parseInt(arr[i]))){
                map.add(Integer.parseInt(arr[i]));
            }
        }
    }
}
//왜틀렸는지ㅡㄹ모르겟네
