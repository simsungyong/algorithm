package lineCote;

public class lineCote2 {
    public static void main(String[] args) {
        String [] arr = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
        String solution = "4132315142";
        int answer=-1;
        for(int i=0; i<arr.length-1; i++){
            for(int k=i+1; k<arr.length; k++){
                int temp = getNum(arr[i],arr[k], solution);
                System.out.println(temp);
                answer = answer > temp ? answer : temp;
            }
        }
        System.out.println(answer);
    }
    public static int getNum(String str1, String str2, String solution){
        int con=0;
        int length=0;
        int num=0;
        int index=0;
        int lastindex=-1;
        for(int i=0; i<solution.length(); i++){
            if((str1.charAt(i)==str2.charAt(i)) && str1.charAt(i)!=solution.charAt(i)){
                num++;
                index=i;
                if(lastindex + 1== index){
                    lastindex=index;
                    con++;
                }else{
                    con=1;
                    lastindex=index;
                }
            }
            length = length> con ? length : con;

        }


        return num + (length*length);
    }
}
