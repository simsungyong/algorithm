package kakaoblind2018.프렌즈4블록;

public class problem4블록 {
    static int temp[][];
    static boolean isCon = true;
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int ans=solution(m,n,board);
        System.out.println(ans);
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int arr[][] = new int[m][n];
        temp = new int [m][n];
        for(int i=0; i<m; i++) {
            for (int k = 0; k < n; k++) {
                arr[i][k] = 1+board[i].charAt(k) - 'A';
            }
        }
        while(isCon){
            arr = search(m,n,arr);


            for(int i=0; i<n; i++){
                for(int k=m-1; k>=1; k--){
                    if(arr[k][i]==0){
                        int k_cnt = k-1;
                        while(true){
                            if(k_cnt < 0|| arr[k_cnt][i]!=0){
                                break;
                            }
                            k_cnt--;
                        }
                        if(k_cnt<0){
                            break;
                        }
                        arr[k][i] = arr[k_cnt][i];
                        arr[k_cnt][i]=0;
                    }
                }
            }
            }

        for(int i=0; i<m; i++) {
            for (int k = 0; k < n; k++) {
                if(arr[i][k]==0){
                    answer++;
                }
            }
        }



        return answer;
    }

    public static int[][] search(int m, int n, int [][] board){
        temp = new int[m][n];
        int isContinue = 0;
        for(int i=0; i<m-1; i++) {
            for (int k = 0; k < n-1; k++) {
                if(board[i][k]!=0 && board[i][k]==board[i+1][k] && board[i][k]==board[i+1][k+1] && board[i][k]==board[i][k+1]){
                    temp[i][k]=1;
                    isContinue = 1;
                }
            }
        }
        isCon = isContinue == 0 ? false : true;

        for(int i=0; i<m-1; i++) {
            for (int k = 0; k < n-1; k++) {
                if(temp[i][k]==1){
                    board[i][k]=0;
                    board[i][k+1]=0;
                    board[i+1][k]=0;
                    board[i+1][k+1]=0;
                }
            }
        }

        return board;
    }


}
