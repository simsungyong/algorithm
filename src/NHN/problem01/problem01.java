package NHN.problem01;

import java.util.Scanner;

public class problem01 {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        StringBuilder sb = new StringBuilder();
        Node arr[] = new Node[numOfAllPlayers];
        for(int i=0; i< numOfAllPlayers-1; i++){
            char temp = (char)(i+66);
            arr[i] = new Node(temp,0);
        }
        arr[numOfAllPlayers-1] = new Node((char)65,0);

        String arrayString = String.valueOf(namesOfQuickPlayers);

        int start = 0;

        Node tnffp = arr[numOfAllPlayers-1];
        tnffp.num +=1;
        for(int i=0; i<numOfGames; i++){
            int move = numOfMovesPerGame[i];
            int nextindex;
            if(move >= 0) {
                nextindex = (start + move) % (numOfAllPlayers-1);
                if (!arrayString.contains(Character.toString(arr[nextindex].index))) {
                    arr[numOfAllPlayers - 1] = arr[nextindex];
                    arr[nextindex] = tnffp;
                    tnffp = arr[numOfAllPlayers - 1];
                }
            }else{
                int convert = (numOfAllPlayers-1) - (Math.abs(move)%(numOfAllPlayers-1));
                nextindex = (convert+start)%(numOfAllPlayers-1);
                if (!arrayString.contains(Character.toString(arr[nextindex].index))) {
                    arr[numOfAllPlayers - 1] = arr[nextindex];
                    arr[nextindex] = tnffp;
                    tnffp = arr[numOfAllPlayers - 1];
                }
            }
            start = nextindex;
            tnffp.num +=1;

        }
        for(Node tmp : arr){
            sb.append(tmp.index +" "+tmp.num+"\n");
        }

        System.out.println(sb.toString());




    }

    private static class Node{
        char index;
        int num;
        Node(char index, int num){
            this.index = index;
            this.num = num;
        }
    }



    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}
