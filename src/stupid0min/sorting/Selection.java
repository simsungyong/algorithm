package stupid0min.sorting;

public class Selection {
    public static void main(String[] args) {
        int[] input = {5,6,2,8,7,23,4,1};
        selectionSortMax(input, input.length);
        for (int a : input) {
            System.out.print(a + " ");
        }
    }

    public  static void selectionSortMax(int[] input, int length) {
        int max;
        int tmp;
        for (int i = length - 1; i > 0; i--) {
            max = i;
            for (int j = i -1; j >= 0; j--) {
                if (input[j] > input[max])
                    max = j;
            }
            tmp = input[i];
            input[i] = input[max];
            input[max] = tmp;
        }
    }
}
//복잡도 O(n^2)
//각 루프마다 최대원소를 찾는다. -> 최대원소와 맨 오른쪽 원소를 교환한다. -> 맨 오른쪽 원소를 빼고 생각한다. -> 하나의 원소만 남을 때까지 위의 루프를 반복한다.
