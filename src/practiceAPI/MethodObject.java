package practiceAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MethodObject {


    public static void main(String[] args) {
        String str = "TEST";
        insideChange(str);
        System.out.println(str);
        List<String> listTest = new ArrayList<>();
        listChange(listTest);
        System.out.println(listTest.get(0));
    }

    public static void insideChange(String str) {
        System.out.println(str.toLowerCase(Locale.ROOT));
    }

    public static void listChange(List<String> list) {
        list.add("testing");
    }
}
