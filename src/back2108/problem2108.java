package back2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class problem2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Prior> q = new PriorityQueue<>();
        PriorityQueue<LargeNum> l = new PriorityQueue<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        double 산술평균 = 0;
        int 범위 = 0;
        int 중앙값 = 0;
        int 최빈값 = 0;
        int arr[] = new int[n];
        for(int i=0 ;i<n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(!hash.containsKey(tmp)){
                hash.put(tmp,1);
            }else{
                hash.replace(tmp,hash.get(tmp)+1);
            }
            산술평균 += tmp;
            q.add(new Prior(tmp));
        }
        산술평균 = Math.round(산술평균/n);
        for(int i=0; i<n; i++){
            int po = q.poll().x;

            arr[i] = po;

            if(hash.containsKey(po)){
                l.add(new LargeNum(po, hash.get(po)));
                hash.remove(po);
            }
        }

        LargeNum first = l.poll();
        LargeNum second;
        if(!l.isEmpty()){
            second = l.poll();
            최빈값 = first.value > second.value ? first.key : second.key;
        }else{
            최빈값 = first.key;
        }








        범위 = arr[n-1] - arr[0];
        중앙값 = arr[n/2];




        System.out.println((int)산술평균);
        System.out.println(중앙값);
        System.out.println(최빈값);
        System.out.println(범위);








    }
}

class Prior implements Comparable<Prior>{
    int x;
    Prior(int x){
        this.x=x;
    }
    @Override
    public int compareTo(Prior o) {
        return this.x-o.x;
    }
}
class LargeNum implements Comparable<LargeNum>{
    int key;
    int value;
    LargeNum(int key, int value){
        this.key=key;
        this.value = value;
    }

    @Override
    public int compareTo(LargeNum o) {
        if(o.value > this.value){
            return 2;
        }else{
            if(o.value == this.value){
                if(this.key > o.key){
                    return 2;
                }else{
                    return -2;
                }
            }else{
                return -2;
            }
        }

    }
}