package kakaoEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problemex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> win = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList();
        for(int i=0; i<num*(num-1); i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstTeam = st.nextToken();
            int firstGame = Integer.parseInt(st.nextToken());
            String secondTeam = st.nextToken();
            int secondGame = Integer.parseInt(st.nextToken());
            if(map.containsKey(firstTeam)){
                if(firstGame == 2){
                    if(win.containsKey(firstTeam)){
                        win.replace(firstTeam, win.get(firstTeam)+1);
                    }else{
                        win.put(firstTeam, 1);
                    }

                    map.replace(firstTeam, map.get(firstTeam)+(firstGame-secondGame));
                    if(map.containsKey(secondTeam)){
                        map.replace(secondTeam, map.get(secondTeam) - (firstGame-secondGame));
                    }else{
                        map.put(secondTeam,  -(firstGame-secondGame));
                    }
                }else{
                    if(win.containsKey(secondTeam)){
                        win.replace(secondTeam, win.get(secondTeam)+1);
                    }else{
                        win.put(secondTeam, 1);
                    }
                    map.replace(firstTeam, map.get(firstTeam)-(secondGame-firstGame));
                    if(map.containsKey(secondTeam)){
                        map.replace(secondTeam, map.get(secondTeam) + (secondGame-firstGame));
                    }else{
                        map.put(secondTeam, (secondGame-firstGame));
                    }
                }

            }else{
                if(firstGame == 2){
                    if(win.containsKey(firstTeam)){
                        win.replace(firstTeam, win.get(firstTeam)+1);
                    }else{
                        win.put(firstTeam, 1);
                    }
                    map.put(firstTeam, (firstGame-secondGame));
                    if(map.containsKey(secondTeam)){
                        map.replace(secondTeam, map.get(secondTeam) - (firstGame-secondGame));
                    }else{
                        map.put(secondTeam, -(firstGame-secondGame));
                    }
                }else{
                    if(win.containsKey(secondTeam)){
                        win.replace(secondTeam, win.get(secondTeam)+1);
                    }else{
                        win.put(secondTeam, 1);
                    }
                    map.put(firstTeam, -(secondGame-firstGame));
                    if(map.containsKey(secondTeam)){
                        map.replace(secondTeam, map.get(secondTeam) + (secondGame-firstGame));
                    }else{
                        map.put(secondTeam, (secondGame-firstGame));
                    }
                }
            }

        }
        list.addAll(map.keySet());
        Collections.sort(list);
        PriorityQueue<Prior> q = new PriorityQueue<>();

        for(String a : list){
            q.add(new Prior(a, win.get(a), map.get(a)));
        }

        while(q.size()>0){
            System.out.println(q.peek().team+" "+q.peek().wingame+" " +q.peek().win);
            q.poll();
        }




    }
}
class Prior implements Comparable<Prior>{
    int win;
    int wingame;
    String team;

    public Prior(String team, int wingame, int win){
        this.team = team;
        this.win = win;
        this.wingame = wingame;
    }
    @Override
    public int compareTo(Prior o) {
        if(this.wingame > o.wingame){
            return -2;
        }
        else if(this.wingame == o.wingame){
            if(this.win > o.win){
                return -1;
            }else if(this.win==o.win){
                if(this.team.charAt(0) < o.team.charAt(0)){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 2;
            }
        }
        else{
            return 3;
        }
    }
}

