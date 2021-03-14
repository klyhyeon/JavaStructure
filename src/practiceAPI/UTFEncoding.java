package practiceAPI;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class UTFEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "I want to 인코드";
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        String result = new String(bytes, "ISO-8859-1");
        System.out.println("input: " + input);
        System.out.println("result: " + result);
    }
}
