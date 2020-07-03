package programHashKit4;


import java.util.*;

public class HashKit4 {
    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop", "kpop", "kpop","pop","classic","kpop", "hiphop"};
        int [] plays = {500, 800, 800, 800, 2500, 700, 1600,800,1000,1600,5000 };
        int arr [] =  solution(genres, plays);
        for(int cnt : arr){
            System.out.print(cnt+" ");
        }
    }

    public static int[] solution(String[] genres, int[] plays){
        ArrayList<Integer> finalList = new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                map.replace(genres[i], map.get(genres[i])+plays[i]);
            }else{
                map.put(genres[i],plays[i]);
            }
        }
        Iterator it = sortByValue(map).iterator();
        while(it.hasNext()){

            PriorityQueue<Prior> q = new PriorityQueue<>();

            String temp = (String) it.next();
            for(int i=0; i<genres.length; i++){
                if(temp.equals(genres[i])){
                    q.add(new Prior(i, plays[i]));
                }
            }



            int forindex=0;

            while(q.size()>0){
                if(forindex==2){
                    break;
                }
                finalList.add(q.poll().index);
                forindex++;
            }


        }
        int [] answer = new int[finalList.size()];
        int size=0;
        for(int cnt : finalList){
            answer[size++] = cnt;
        }
        return answer;
    }
    public static List sortByValue(Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list, new Comparator() {


            public int compare(Object o1, Object o2) {

                Object v1 = map.get(o1);

                Object v2 = map.get(o2);


                return ((Comparable) v2).compareTo(v1);

            }
        });

        return list;
    }

}
class Prior implements Comparable<Prior>{
    int index;
    int time;
    public Prior(int index, int time){
        this.index = index;
        this.time = time;
    }
    @Override
     public int compareTo(Prior o) {
        if(this.time < o.time){
            return 1;
        }else if(this.time==o.time){
            if(this.index > o.index){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
