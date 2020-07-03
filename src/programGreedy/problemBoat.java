package programGreedy;

import java.util.Arrays;

public class problemBoat {
    public static void main(String[] args) {
        int [] people = {70, 50, 80,71,120, 50, 45, 89, 41};
        int limit = 130;
        System.out.print(solution(people,limit));

    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int templimit = limit;
        int peopleSort [] = people;
        Arrays.sort(peopleSort);
        for(int i=0; i<people.length; i++){
            if(templimit-people[i] >= 40){
                templimit-=people[i];
            }else{
                templimit = limit;
                answer++;
            }
        }
        return answer;
    }
}
