package skillCheck03;

public class skillCheck03 {
    public static void main(String[] args) {
        String str = "Z";

        System.out.print(solution(str));

    }
    public static int solution(String name) {
        int answer = 0;
        int first=0;
        int last=0;
        for(int i=0; i<name.length(); i++){
            if(i!=0 &&(name.charAt(i)-'A')!=0 && first==0){
                first = i;
            }
            if((name.charAt(i)-'A')!=0){
                last = i;
            }


            if((name.charAt(i)-'A') <=13){

                answer += (name.charAt(i)-'A');
            }else{

                answer += (26-(name.charAt(i)-'A'));
            }
        }

        if((name.length()-first) >  last ){
            answer+=last;
        }else{
            answer+=(name.length()-first);
        }
        return answer;
    }
}
