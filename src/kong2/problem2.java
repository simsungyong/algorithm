package kong2;

public class problem2 {
    public static void main(String[] args) {
        int input[] = {6,8,9,9,4,3,2,9,0,1,8,9};
        int arr []= func(input);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    public static int[] func(int input[]){
        int answer[] = new int[input.length];
        boolean check = true;
        for(int i=input.length-1; i>=0; i--){
            if(input[i]==9){
               if(check){
                   answer[i]=0;
                   check = true;
               }else{
                   answer[i] = input[i];
               }
            }else{
                if(check){
                    check=false;
                    answer[i] = input[i]+1;
                }else{
                    answer[i] = input[i];
                }
            }
        }
        return answer;
    }
}
