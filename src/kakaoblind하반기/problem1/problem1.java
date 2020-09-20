package kakaoblind하반기.problem1;

public class problem1 {
    public static void main(String[] args) {
        String input = "abcdefghijklmn.p";
        solution(input);
    }

    public static String solution(String new_id) {
        String answer = "";

        String input = new_id.toLowerCase();
        String st2 = "";
        int tmp;
        for (int i = 0; i < input.length(); i++) {
            tmp = (int) input.charAt(i);
            if (tmp >= 97 && tmp <= 122) {
                st2 += (char) tmp;
            } else if (tmp >= 48 && tmp <= 57) {
                st2 += (char) tmp;
            } else if (tmp == 45 || tmp == 46 || tmp == 95) {
                st2 += (char) tmp;
            }
        }

        String st3 = "";
        char ch = ';';
        for (int i = 0; i < st2.length(); i++) {
            char c = st2.charAt(i);
            if (ch == '.' && c == '.') continue;
            st2 += c;
            ch = c;
        }

        String st4 = "";
        for (int i = 0; i < st3.length(); i++) {
            char c = st3.charAt(i);
            if (i == 0 && c == '.') continue;
            if (i == st3.length() - 1 && c == '.') continue;
            st4 += c;
        }

        String st5 = "";
        if (st4.length() == 0) st5 += "a";
        else st5 = st4;

        String st6 = "";
        if (st5.length() >= 16) {
            if (st5.charAt(14) == '.') st6 = st5.substring(0, 14);
            else st6 = st5.substring(0, 15);
        } else st6 = st5;

        String st7 = st6;
        if (st7.length() <= 2) {
            char lastCh = st7.charAt(st7.length() - 1);
            while (st7.length() <= 2) {
                st7 += lastCh;
            }
        }

        answer += st7;

        return answer;
    }
}

