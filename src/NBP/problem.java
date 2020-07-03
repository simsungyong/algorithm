package NBP;

public class problem {
    static int answer;
    static int length;
    static char input [];
    static boolean check [];
    public static void main(String[] args) {
        answer=0;

        solution("<<<<><<>>");


    }

    public static void solution(String p){
        input = p.toCharArray();
        length = p.length();

        for(int i=0; i<length; i++){
            check = new boolean[length];
            find(i);
        }

        System.out.println(answer);

    }

    public static void find(int index){
        if(index<0 || index == length){
            answer++;
            return;
        }

        if(check[index]){
            return;
        }

        check[index] = true;
        if(input[index]=='<' ){

            find(index-1);
        }else{
            find(index+1);
        }
    }
}
