package javastructure.arraystructure;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    public static void main(String[] args) {
        int[] data = new int[10];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }
        int[] ori = Arrays.copyOf(data, data.length);
        Arrays.sort(data);
        System.out.println("ori: " + Arrays.toString(ori));
        System.out.println("sort: " + Arrays.toString(data));
    }


}
