package javastructure.arraystructure;

public class InsertionSort {

    public static void insertionSort(char[] data) {
        int l = data.length;
        for (int i = 1; i < l; i++) {
            char target = data[i];
            int j = i;
            while (j > 0 && data[j-1] > target) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = target;
        }
    }

    public static void insertionSort2(char[] data) {
        //삽입정렬은 타겟자리에 다른 인덱스 데이터들을 옮겨주는 일
        //맨 앞에서부터 하기 때문에 타겟보다 큰 값이 있으면 바로 멈춰도 됨
        int l = data.length;
        for (int i = 1; i < l; i++) {
            char target = data[i];
            for (int j = i; j > 0; j--) {
                if (target < data[j - 1])
                    data[j] = data[j - 1];
                else {
                    data[j] = target;
                    break;
                }
            }
        }
    }

    public void insertionSort3(char[] data) {
        int l = data.length;
        for (int i = 1; i < l; i++) {
            char target = data[i];
            int j = i;
            for (j = j; j > 0; j--) {
                if (target < data[j-1])
                    data[j] = data[j-1];
                else
                    break;
            }
            data[j] = target;
        }
    }
}
