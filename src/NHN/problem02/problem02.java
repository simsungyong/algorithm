package NHN.problem02;

import java.util.Scanner;
import java.util.Stack;

public class problem02 {
    private static void solution(int numOfOrder, String[] orderArr) {
        String[] answer = new String[numOfOrder];
        for (int i = 0; i < numOfOrder; i++) {
            String order = orderArr[i];
            System.out.println(order);
            int n=0;
            Stack<Character> stack = new Stack<>();
            for (int k=0; k< order.length(); k++) {
                char ch  = order.charAt(k);
                if (ch-'0' >=1 && ch-'0' <=9) { // ex) 3G
                    if(order.charAt(k+1) != '('){
                        for(int j=0; j<ch-'0'; j++){
                            stack.push(order.charAt(k+1));
                        }
                        k++;
                    }else{
                        stack.push(ch);
                    }
                } else {
                    if(ch != ')'){
                        stack.push(ch);
                    }

                    else {
                        String changedString = "";
                        String current = "";
                        char nextChar = stack.pop();
                        while(nextChar != '(') {
                            current = nextChar + current;
                            nextChar = stack.pop();
                        }

                        char next = stack.pop();
                        if(next - '0' >= 0 && next - '0' <= 9) {
                            changedString = changeNumber(next - '0', current);
                        } else {
                            changedString = changeString(next, current);
                        }
                        for(char chs : changedString.toCharArray()) {
                            stack.push(chs);
                        }

                    }
                }
            }
            String ans = "";
            while (!stack.isEmpty()) {
                ans = stack.pop() + ans;
            }
            answer[i] = ans;
        }

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static String changeNumber(int num, String str) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += str;
        }
        return result;
    }

    static String changeString(char ch, String str) {
        char[] chars = new char[str.length() * 2];
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            int idx = i * 2;
            chars[idx] = ch;
            chars[idx + 1] = strs[i];
        }
        return chars.toString();
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) {
        solution(2, new String[]{"3(R2(GB4E))", "2(B(R)2(G))1(B2(B(R)))"});
    }
}