package stupid0min.sorting;

public class Insertion {
    public static void main(String[] args) {
        int [] input = {5,6,2,8,7,23,4,1,44};
        insertionSort(input, input.length);
        for (int a : input) {
            System.out.print(a + " ");
        }
    }
    public static void insertionSort(int[] input, int length) {
        int tmp;
        for (int i = 1; i < length; i++) {

            for (int j = i; j > 0; j--) {

                if (input[j - 1] > input[j]) {

                    tmp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = tmp;

                }
            }
        }
    }
}
//맨 처음 인덱스에 있는 원소를 정렬되어있는 상태라고 보고, 두번째 인덱스에 있는 데이터를 이 정렬된 배열에 삽입하면서, 다시 정렬된 상태가 하도록 만든다.
//앞에서 부터 비교하면서 찾는 방법, 뒤에서 부터 비교하면서 찾는 방법이 있다.
//
//얼핏 생각하면 같은 방법인것 처럼 보이나, 다른점이 있다.
//
//앞에서 부터 인덱스의 요소들을 비교하면서 자리를 찾는다면, k번째 인덱스보다 작은 값들을 일일히 검사를 해야한다. 이것은 뒤에서 부터 자리를 찾는 작업에서도 똑같이 이루어진다.
//
//하지만, 들어갈 위치를 찾았을 때, 배열이라는 자료구조의 특성상 해당 위치부터 k-1인덱스까지의 요소들을 한칸씩 shift 시키는 작업이 필요하다.
//
//결과적으로 앞에서부터 비교를 하면, 모든 데이터를 한번씩은 적어도 봐야된다.
//
//그러나, 뒤에서 부터 비교한다면 비교와 동시에 switch하는 작업을 행해줌으로써 자동으로 shift 작업을 수행한다.
//