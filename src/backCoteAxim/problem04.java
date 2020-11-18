package backCoteAxim;

public class problem04 {
    public static void main(String[] args) {

        String [] arr = {"09:05 10", "12:20 5","13:25 6","14:24 5", "15:30 40"};
        System.out.println(solution(arr, "12:00", 35));
    }
    public static int solution(String[] bakery_schedule, String current_time, int K) {
        String time[] = current_time.split(":");
        int endHour=0;
        int endM=0;
        boolean check = false;
        for(int i=0; i<bakery_schedule.length; i++){
            String data[] = bakery_schedule[i].split(" ");
            String cnt_time[] = data[0].split(":");
            if(Integer.parseInt(time[0]) > Integer.parseInt(cnt_time[0])){
                continue;
            }

            if(Integer.parseInt(time[0]) == Integer.parseInt(cnt_time[0])){
                if(Integer.parseInt(time[1]) > Integer.parseInt(cnt_time[1])){
                    continue;
                }
            }

            K -= Integer.parseInt(data[1]);
            if(K<=0){
                endHour = Integer.parseInt(cnt_time[0]);
                endM = Integer.parseInt(cnt_time[1]);
                check =true;
                break;
            }
        }

        if(!check){
            return -1;
        }

        int answer = (endHour*60+endM) - (60*Integer.parseInt(time[0])+Integer.parseInt(time[1]));

        return answer;
    }
}
