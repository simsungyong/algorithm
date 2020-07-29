package skillCheck06;

import java.util.Arrays;

public class problem06 {
    public static void main(String[] args) {
        int people[] = {80,50,60,70};
        int limit = 110;
        System.out.print(solution(people,limit));

    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int index= people.length-1;
        for(int i= 0; i<=index; i++,answer++){
            while(index > i && people[i]+people[index--] > limit){
                answer++;
            }

        }
        return answer;
    }
}
