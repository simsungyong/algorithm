package wintercote;

public class problem02 {
    public static void main(String[] args) {
        String enc = "qyyigoptvfb";
        String key = "abcdefghijk";


        System.out.println(solution(enc,key,-13));
    }
    public static String solution(String encrypted_text, String key, int rotation) {
        String answer = "";

        int arr[] = new int[encrypted_text.length()];
        for(int i=0; i<encrypted_text.length(); i++){
            int alpha = (int)encrypted_text.charAt(i);
            int index = i-(rotation%encrypted_text.length());
            if(index<0){
                index += key.length();
            }else if(index>encrypted_text.length()-1){
                index -= key.length();
            }
            arr[index] = alpha;
        }

        for(int i=0; i<key.length(); i++){

            int nextindex = arr[i]-(key.charAt(i)-'a')-1;
            nextindex = nextindex <97 ? nextindex+26 : nextindex;

            answer += (char)nextindex;
        }
        return answer;
    }
}
