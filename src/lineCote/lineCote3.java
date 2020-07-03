package lineCote;




import java.util.Arrays;
import java.util.HashMap;

public class lineCote3 {
    public static void main(String[] args) {
        String[][] snapshots = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
        String[][] transactions = {{"1", "SAVE", "ACCOUNT2", "100"}, {"2", "WITHDRAW", "ACCOUNT1", "50"}, {"1", "SAVE", "ACCOUNT2", "100"}, {"4", "SAVE", "ACCOUNT3", "500"}, {"3", "WITHDRAW", "ACCOUNT2", "30"}};


        solution(snapshots, transactions);
    }


    public static void solution(String[][] snapshots, String[][] transactions) {
        String[][] answer;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < transactions.length; i++) {
            if (map1.getOrDefault(transactions[i][0], 0) > 0) {
                continue;
            } else {
                map1.put(transactions[i][0], map1.getOrDefault(transactions[i][0], 0) + 1);
                if (transactions[i][1] == "SAVE") {
                    map2.put(transactions[i][2], map2.getOrDefault(transactions[i][2], 0) + Integer.parseInt(transactions[i][3]));
                } else {
                    map2.put(transactions[i][2], map2.getOrDefault(transactions[i][2], 0) - Integer.parseInt(transactions[i][3]));
                }
            }
        }

        for (int i = 0; i < snapshots.length; i++) {
            map2.put(snapshots[i][0], map2.getOrDefault(snapshots[i][0], 0) + Integer.parseInt(snapshots[i][1]));
        }

        String[] keys = map2.keySet().toArray(new String[map2.size()]);
        Arrays.sort(keys);
        answer = new String[keys.length][2];
        for (int i = 0; i < keys.length; i++) {
            answer[i][0] = keys[i];
            answer[i][1] = map2.get(keys[i]).toString();
        }
        for (int i = 0; i < keys.length; i++) {
            System.out.print(answer[i][0] + " " + answer[i][1]);
            System.out.println();
        }


    }
}