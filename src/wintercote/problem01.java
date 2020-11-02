package wintercote;

import java.util.ArrayList;

public class problem01 {
    public static void main(String[] args) {
        int n = 7;
        int arr[] []= {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
        System.out.println(solution(n,arr));

    }

    public static String solution(int n, int[][] delivery) {
        String answer = "";
        int typearr[] = new int[n+1];
        ArrayList<Integer> list[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<delivery.length; i++){

            int a = delivery[i][0];
            int b = delivery[i][1];
            int type = delivery[i][2];

            if(type==1){
                if(typearr[a]==0 && list[a].size()>0){
                    typearr[a] = 1;
                    for(int k=0; k<list[a].size(); k++){
                        typearr[list[a].get(k)] = 2;
                    }
                }

                if(typearr[b]==0 && list[b].size()>0){
                    typearr[b] = 1;
                    for(int k=0; k<list[b].size(); k++){
                        typearr[list[b].get(k)] = 2;
                    }
                }

                typearr[a]=1;
                typearr[b]=1;

            }else{
                if(typearr[a]==1){
                    typearr[b]=2;
                }else if(typearr[b] ==1){
                    typearr[a] = 2;
                }
                list[a].add(b);
                list[b].add(a);
            }
        }

        for(int i=1; i<=n; i++){
            if(typearr[i]==1){
                answer +="O";
            }else if(typearr[i]==2){
                answer+="X";
            }else{
                answer+="?";
            }
        }

        return answer;
    }
}
