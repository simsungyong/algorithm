package stupid0min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class study07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Students> list = new ArrayList<>();

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            list.add(new Students(name, kor, math, eng));
        }

        Collections.sort(list);

        for(Students tmp : list){
            System.out.println(tmp.name + " "+tmp.sum+" "+tmp.math);
        }

    }
}




class Students implements Comparable<Students>{
    String name;
    int kor, math, eng, sum;

    Students(String name, int kor, int math, int eng){
        this.name = name;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.sum = kor+math+eng;
    }

    @Override
    public int compareTo(Students o) {

        if(this.sum > o.sum){
            return -1;
        }else{
            if(this.sum == o.sum){
                if(this.math > o.math){
                    return -1;
                }
                else{
                    return 1;
                }
            }else{
                return 1;
            }
        }
    }
}