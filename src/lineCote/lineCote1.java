package lineCote;

public class lineCote1 {
    public static void main(String[] args) {
        String load = "001100";
        int n = 6;
        int result = -1;
        boolean con=true;
        for(int i=0; i<load.length(); i++){
            if(load.charAt(i)=='0'){
                int temp = change(i,load,n);
                result = temp > result ? temp: result;
            }
        }
        System.out.println(result);






    }
    public static int search(String afterload){
        int start=0;
        int end=0;
        int length=0;

            for(int i=0; i<afterload.length(); i++){
                if(afterload.charAt(i)=='0') {
                    end=i;
                    if (end-start > length) {
                        length = end-start;
                        start = end+1;

                    }else{
                        start = end+1;
                    }
                }
                if(i==afterload.length()-1){
                    end = i;
                    if(start==0){
                        length=afterload.length();
                    }
                    if(end-start > length){
                        length = end-start;
                }
                }
            }
        return length;


    }
    public static int change(int index, String load, int n){
        int temp = n;
        StringBuilder tempload = new StringBuilder(load);
        for(int i = index; i<load.length(); i++){
            if(load.charAt(i)=='0'){
                if(temp>0){
                    tempload.setCharAt(i,'1');
                    temp--;
                }
            }
        }
        System.out.println(tempload.toString());
        int num = search(tempload.toString());
        System.out.println(num);

        return num;
    }

}
