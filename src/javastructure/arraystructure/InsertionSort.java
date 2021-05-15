package javastructure.arraystructure;

public class InsertionSort {

    public static void insertionSort(char[] data) {
        int l = data.length;
        for (int i = 1; i < l; i++) {
            char target = data[i];
            int j = i;
            while (j > 0 && data[j-1] < target) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = target;
        }
    }
}
