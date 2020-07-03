package back2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList [] list =new ArrayList[n];
        int goal = Integer.parseInt(st.nextToken());
        boolean possible = true;

        for(int i=0; i<n; i++){
            list[i] = new ArrayList();
            list[i].add(Integer.parseInt(br.readLine()));
        }
        int index=0;




        while(possible){
            int count = 0;
            for(int i =0; i<n; i++) {
                int newValue = 0;
                for (int k = 0; k < n; k++) {
                    int temp = (int) list[i].get(index) + (int) list[k].get(0);
                    if (temp > newValue && temp <= goal) {
                        if(temp==goal){
                            System.out.println(index+2);
                            return;
                        }
                        else{
                            newValue = temp;
                        }
                    }
                }


                if(newValue==0){
                    count++;
                }
                list[i].add(newValue);
            }
            if(count == n){
                System.out.println(-1);
                return;
            }else{
                index++;
            }
        }


    }
}
