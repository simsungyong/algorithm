package coupang.problem3;

public class problem3 {
    public static void main(String[] args) {

        int arr[] = solution(10);
        System.out.println(arr[0]+" "+arr[1]);
    }

    public static int[] solution(int N){
        int answer[] = new int[2];
        int max = Integer.MIN_VALUE;
        int maxindex=0;
        for(int i=2; i<10; i++){
            int ans = toDeposition(N,i);
            System.out.println(ans);
            if(max <= ans){
                max= ans;
                maxindex = i;
            }
        }

        answer[0] = maxindex;
        answer[1] = max;
        return answer;
    }

    public static int toDeposition(int value, int i){
        String returnString = "";
        int num=1;

        while(value != 0){

                returnString = (value % i) + returnString;
                value /= i;
        }

        System.out.println(returnString);

        for(int k=0; k<returnString.length(); k++){
            if(!returnString.substring(k,k+1).equals("0")){
                num *= Integer.parseInt(returnString.substring(k,k+1));
            }
        }

        return num;

    }
}
