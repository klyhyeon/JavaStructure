package practiceAPI;

import java.util.Optional;

public class OptionalPrac {

    public static void main(String[] args) {
        Optional<String[]> optStr = Optional.ofNullable(null);
        System.out.println(optStr.orElse(null));
    }
}
