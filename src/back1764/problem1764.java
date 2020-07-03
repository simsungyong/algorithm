package back1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//사전적 단어 순 해쉬셋!! arraylist쓰면 시간초과!!
public class problem1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> arr = new ArrayList();
        HashSet hs = new HashSet();
        for(int i=0; i<n; i++){
            String cnt  = br.readLine();
            hs.add(cnt);
        }

        for(int i=0; i<m; i++){
            String temp = br.readLine();
            if(hs.contains(temp)){
                arr.add(temp);
            }
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }


    }



}

