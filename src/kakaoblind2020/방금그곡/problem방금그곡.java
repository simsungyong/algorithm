package kakaoblind2020.방금그곡;

public class problem방금그곡 {
    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String [] input = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String answer = solution(m,input);
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String [] temp;
        for(int i=0; i<musicinfos.length; i++){
            temp = musicinfos[i].split(",");

        }
        return answer;
    }
}
