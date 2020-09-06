package kong5;

public class problem5 {
    public static void main(String[] args) {
        System.out.println(func(7));
    }

    public static int func(int n){
        int a=0;
        int b=1;
        for(int i=0; i<n; i++){
            int tmp = b;
            b= a+b;
            a = tmp;

        }

        return a;
    }
}
