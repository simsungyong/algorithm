package kakaoblind2020.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

public class problem오픈카톡방 {
    public static void main(String[] args) {
        String input[] = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Leave uid1234"};
                //"Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String answer[] = solution(input);
        for(String temp:answer){
            System.out.println(temp);
        }
    }
    public static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();
        String temp[];
        for(int i=0; i<record.length; i++){
            temp = record[i].split(" ");
            if(temp[0].equals("Enter")) {
                if(map.containsKey(temp[0])){
                    map.replace(temp[1], map.get(temp[1])+" "+temp[2]);
                }else{
                    map.put(temp[1], temp[2]);
                }

                list.add(new Node(temp[1], "들어왔습니다."));
            }else if(temp[0].equals("Leave")){
                list.add(new Node(temp[1],"나갔습니다."));
                map.replace(temp[1], map.get(temp[1])+" null");

            }else{
                map.replace(temp[1], map.get(temp[1])+" "+temp[2]);
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
                temp =  map.get(list.get(i).id).split(" ");
                if(temp[temp.length-1].equals("null")){
                    answer[i] = temp[temp.length-2]+"님이 "+list.get(i).type;
                }else{
                    answer[i] = temp[temp.length-1]+"님이 "+list.get(i).type;
                }
            }

        return answer;
    }
}

class Node{
    String id;
    String type;

    Node(String id, String type){
        this.id = id;
        this.type = type;

    }
}
