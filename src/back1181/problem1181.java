package back1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem1181 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Sort> q = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            q.add(new Sort(tmp));
        }
        String before="";
        while(!q.isEmpty()){
            String tmp = q.poll().str;
            if(!tmp.equals(before)){
                before = tmp;
                System.out.println(tmp);
            }

        }
    }
}
class Sort implements Comparable<Sort> {
    String str;

    Sort(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(Sort o) {
        if (this.str.length() > o.str.length()) {
            return 1;
        } else if (this.str.length() == o.str.length()) {
            int isBig = 0;
                for(int i=0; i<o.str.length(); i++) {
                    if (this.str.charAt(i) - 'a' > o.str.charAt(i)-'a') {
                        isBig = 1;
                        break;
                    }else if(this.str.charAt(i) - 'a' < o.str.charAt(i)-'a'){
                        isBig = 0;
                        break;
                    }
                }
                if(isBig==0){
                    return -1;
                }else{
                    return 1;
                }

        } else {
            return -1;
        }
    }
}
