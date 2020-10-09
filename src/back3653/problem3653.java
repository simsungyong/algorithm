package back3653;

import java.util.ArrayList;
import java.util.Scanner;

public class problem3653 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0; i<num; i++) {
            int movie_cnt = sc.nextInt(); //가지고 있는 영화 수
            int watch_cnt = sc.nextInt(); //보려고 하는 영화 수
            for(int j=movie_cnt; j>0; j--) {
                list.add(j);
            }

            for(int j=watch_cnt; j>0; j--) {
                int order = sc.nextInt();
                list2.add(list.size()-list.indexOf(order)-1);
                list.remove(list.indexOf(order));
                list.add(order);

            }
            for(int j=0; j<watch_cnt; j++) {
                if(j==watch_cnt-1) {
                    System.out.println(list2.get(j));
                }else {
                    System.out.printf("%d ",list2.get(j));
                }
            }
            list.clear();
            list2.clear();
        }
    }
}
