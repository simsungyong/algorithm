package kakaoSecret;

import java.io.*;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        char[] ch = input.toCharArray();



        boolean[] checks = new boolean[5];

        if(ch.length >= 10) checks[4] = true;

        for(char cnt : ch) {
            if((int)cnt >= 48 && (int)cnt <= 57) {
                if(checks[2]) continue;
                checks[2] = true;
            } else if((int)cnt >= 65 && (int)cnt <= 90) {
                if(checks[1]) continue;
                checks[1] = true;
            } else if((int)cnt >= 97 && (int)cnt <= 122) {
                if(checks[0]) continue;
                checks[0] = true;
            } else {
                if(checks[3]) continue;
                checks[3] = true;
            }
        }

        int level = 0;

        for(boolean check : checks) {
            level = check ? level+1 : level;
        }

        String answer = null;
        switch (level) {
            case 1: answer = "LEVEL1"; break;
            case 2: answer = "LEVEL2"; break;
            case 3: answer = "LEVEL3"; break;
            case 4: answer = "LEVEL4"; break;
            case 5: answer = "LEVEL5"; break;
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
