package movexCote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class movex04 {
    public static void main(String[] args) {
        String [][] arr = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
        solution(arr, "david");
    }
    public static String[] solution(String[][] friends, String user_id) {
        String[] answer;
        List<Integer> ansList = new ArrayList<>();
        HashMap<String, Integer> idMap = new HashMap<>();
        HashMap<Integer, String> nameMap = new HashMap<>();
        int id = 1;
        int maxCnt = Integer.MIN_VALUE;
        List<Integer>[] graph = new ArrayList[20000];
        boolean[] check = new boolean[20000];
        int[] cnt = new int[20000];
        check[0] = true;
        idMap.put(user_id, 0);
        nameMap.put(0, user_id);
        for (String[] friend : friends) {
            String f1 = friend[0];
            String f2 = friend[1];
            int idF1;
            int idF2;
            if (!idMap.containsKey(f1)) {
                idF1 = id;
                idMap.put(f1, idF1);
                nameMap.put(idF1, f1);
                id++;
            } else {
                idF1 = idMap.get(f1);
            }
            if (!idMap.containsKey(f2)) {
                idF2 = id;
                idMap.put(f2, idF2);
                nameMap.put(idF2, f2);
                id++;
            } else {
                idF2 = idMap.get(f2);
            }
            if (graph[idF1] == null) {
                graph[idF1] = new ArrayList<>();
            }
            if (graph[idF2] == null) {
                graph[idF2] = new ArrayList<>();
            }
            graph[idF1].add(idF2);
            graph[idF2].add(idF1);

            if (idF1 == 0) {
                check[idF2] = true;
            } else if (idF2 == 0) {
                check[idF1] = true;
            }
        }

        for (int fId : graph[0]) {
            if (graph[fId] != null) {
                for (int next : graph[fId]) {
                    if (!check[next]) {
                        cnt[next]++;
                        if (cnt[next] > maxCnt) {
                            maxCnt = cnt[next];
                            ansList.clear();
                            ansList.add(next);
                        } else if (cnt[next] == maxCnt) {
                            ansList.add(next);
                        }
                    }
                }
            }
        }

        answer = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = nameMap.get(ansList.get(i));
        }
        Arrays.sort(answer);
        return answer;
    }
}
