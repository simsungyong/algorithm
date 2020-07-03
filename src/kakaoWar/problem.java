package kakaoWar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int min = Integer.MAX_VALUE;
    static Map<String, Integer> map;
    static Map<String, Integer> check;
    static Set set;
    static Iterator it;
    static int soldier;
    static Stack stack = new Stack();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        ArrayList<String> arr= new ArrayList<>();
        map = new HashMap<>();
        check =new HashMap<>();
        soldier = Integer.parseInt(st.nextToken());
        int infoNum = Integer.parseInt(st.nextToken());
        for(int i=0; i<infoNum; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken()+st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
            check.put(key, 0);
        }

        set = map.keySet();
        it = set.iterator();


        int problemN = Integer.parseInt(br.readLine());
        for(int i=0 ; i<problemN; i++){
            min = 0;
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if(s1.equals(s2)){
               min = 0;
            }else if(map.containsKey(s1+s2)){
                min=map.get(s1+s2);
            }
            else{
                System.out.println("dfs 시작");
                sol(s1+s2,0, s2);
            }

            System.out.println("최소값 : " + min);
        }


//        for(String key: list){
//            System.out.print(key+" ");
//            System.out.println(check.get(key));
//
//        }
    }
    public static void sol(String s, int value, String target){
        if(s.substring(soldier,soldier+soldier).equals(target)){
            min = min > value ? value : min;
            return;
        };

        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println(key);
            if(key.substring(0,soldier).equals(s.substring(0,soldier))){
                System.out.println(key.substring(0,soldier)+"ㄴㄴ");
                stack.push(key);
            }
        }
        if(stack.empty()){
            min = -1;
            System.out.println("비어잇다");
            return;
        }

        String pop = stack.pop().toString();

        if(check.get(pop)==0){
            check.replace(pop, 1);
            System.out.println(pop+" 뺐다");
            sol(pop,  map.get(pop)+value, target);
        }
        check.replace(pop, 0);





    }
}
