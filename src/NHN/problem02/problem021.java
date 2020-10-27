package NHN.problem02;

import java.util.Scanner;

public class problem021 {
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        int answer = 0;
        for(int i=0; i<day; i++){
            int start = 0;

            for(int k=1; k<width; k++){
                int height = Math.min(blocks[i][start], blocks[i][k]);
                for(int j = start+1; j<k; j++){
                    if(height-blocks[i][j]> 0){
                        answer += (height-blocks[i][j]);
                        blocks[i][j] = height;
                    }
                }

                if(blocks[i][start] < blocks[i][k]){
                    start = k;
                }
            }

            if(i!=day-1)
            for(int k=0; k<width; k++){
                blocks[i+1][k] += blocks[i][k];
            }

            System.out.println(answer);
        }

        System.out.println(answer);

    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}