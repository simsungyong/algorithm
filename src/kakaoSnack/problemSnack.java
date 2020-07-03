package kakaoSnack;


import java.io.*;
import java.util.StringTokenizer;

public class problemSnack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        float sum = 0;

        Double[] list = new Double[n];
        for (int i = 0; i < n; i++) {
            Double d = Double.parseDouble(br.readLine());
            list[i] = d;
            sum += d;
        }
        double targetNum = sum / k;
        targetNum = findFirstMax(list, targetNum, k);
        targetNum = findSecondMax(list, targetNum, k);
        targetNum = Math.round(targetNum * 100) / 100.0;

        bw.write(String.valueOf(targetNum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static double findSecondMax(Double[] list, double targetNum, int k) {
        int cnt = 0;
        double newTargetNum = targetNum;
        for (Double d : list) {
            cnt += Math.floor(d / targetNum);
        }
        if (cnt == k) {
            newTargetNum = findSecondMax(list, targetNum + 0.01, k);
            return newTargetNum;
        } else {
            return newTargetNum;
        }
    }

    private static double findFirstMax(Double[] list, double targetNum, int k) {
        int cnt = 0;
        double newTargetNum = targetNum;
        for (Double d : list) {
            cnt += Math.floor(d / newTargetNum);
        }
        if (cnt != k) {
            newTargetNum = findFirstMax(list, targetNum - 0.1, k);
            return newTargetNum;
        } else {
            return newTargetNum;
        }

    }
}