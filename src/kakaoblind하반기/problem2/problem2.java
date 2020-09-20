package kakaoblind하반기.problem2;

import java.util.ArrayList;
import java.util.Arrays;


public class problem2 {
    static ArrayList<String> answer = new ArrayList<>();
    static ArrayList<Node> tmp = new ArrayList<>();
    static int alpha[];
    static StringBuilder sb;
    static String[] order;
    public static void main(String[] args) {
        String [] arr = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course = {2,3,4};

        String answer0[] = solution(arr,course);



    }

    public static String[] solution(String[] orders, int[] course) {
        order = orders;
        alpha = new int[26];
        ArrayList<String> subarr;
        for(int i=0; i<orders.length; i++){
            String tmp = orders[i];
            for(int k=0; k<tmp.length(); k++){
                int single = tmp.charAt(k)-'A';
                alpha[single] +=1;
            }
        }


        for(int i=0; i<course.length; i++){
            subarr = new ArrayList<>();
            for(int k=0; k<26; k++){
                if(alpha[k] < 2){
                    continue;
                }
                subarr.add(String.valueOf((char)(k+65)));
            }
            if(subarr.size() >= course[i]){
                printCombination(subarr,course[i],subarr.size());
            }

            for(int k=0; k<tmp.size(); k++){
                answer.add(tmp.get(k).str);
            }
            tmp.clear();
        }


        String[] answerarr = answer.toArray(new String[answer.size()]);
        Arrays.sort(answerarr);
        return answerarr;
    }

    static void printCombination(ArrayList arr, int n, int size)
    {
        String data[]=new String[n];

        combinationUtil(arr, data,0,size-1, 0, n);
    }


    public static void combinationUtil(ArrayList arr, String data[], int start,
                                int end, int index, int n)
    {

        if (index == n)
        {
            sb = new StringBuilder();
            for (int j=0; j<n; j++){
                sb.append(data[j]);
            }

            checkvalid(sb.toString(),order );

            return;
        }


        for (int i=start; i<=end && end-i+1 >= n-index; i++)
        {
            data[index] = String.valueOf(arr.get(i));
            combinationUtil(arr, data, i+1, end, index+1, n);
        }
    }

    public static void checkvalid(String tmpcourse, String [] orders){
        int num=0;
        for(int i=0; i<orders.length; i++){
            for(int k=0; k<tmpcourse.length(); k++){
                if(!orders[i].contains(tmpcourse.substring(k,k+1))){
                    break;
                }

                if(k==tmpcourse.length()-1){
                    num++;
                }
            }
        }

        if(num>=2){
            if(tmp.size()>0){
                if(tmp.get(0).value == num){
                    tmp.add(new Node(num, tmpcourse));
                }else if(tmp.get(0).value < num){
                    tmp.clear();
                    tmp.add(new Node(num,tmpcourse));
                }
            }else{
                tmp.add(new Node(num,tmpcourse));
            }
        }



        }

}

class Node {
    int value;
    String str;
    Node(int value, String str){
        this.value = value;
        this.str = str;
    }
}
