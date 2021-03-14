package practiceAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFunction {

    public static void main(String[] args) {
        List<String> listOfString = Arrays.asList("banana", "apple", "mango");
        System.out.println(listOfString.get(0));
        System.out.println(listOfString.stream()
                    .map(String::toUpperCase)

                    .collect(Collectors.toList()));

        System.out.println(listOfString);
    }
}
