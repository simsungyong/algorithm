package 돌다리;


public class problem {

    public static void main(String[] args) {
        int arr[] ={3, 4, 7, 4, 6, 3, 7, 4, 8, 2,1,2,1};
        int k=4;

        System.out.print(solution(arr,k));
    }
    public static int solution(int[] stones, int k) {
        int right = 0;
        for(int a:stones){
            right = right > a ?right: a;
        }

        int left=0;

        while(left <= right){
            int mid = (left+right)/2;
            int lastindex =-1;
            int continuenum = 0;
            int longest = Integer.MIN_VALUE;
            for(int i=0; i<stones.length; i++){
                if((stones[i]-mid)<=0){
                    if(lastindex+1==i){
                        continuenum++;
                        lastindex = i;
                    }else{
                        continuenum = 1;
                        lastindex = i;
                    }
                }

                longest = Math.max(longest,continuenum);
            }

            if(longest >= k){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }



        return left;
    }
}
