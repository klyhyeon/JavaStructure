package practiceAPI;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class UTFEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "I want to 인코드";
        byte[] bytes = input.getBytes();
        String result = new String(bytes, "UTF-8");
    }
}
