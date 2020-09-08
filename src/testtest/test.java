package testtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            arr[i] = st.nextToken().charAt(0)-'D';
        }
        for(int i=0; i<5; i++){
            System.out.println(arr[i]);
        }

    }
}
