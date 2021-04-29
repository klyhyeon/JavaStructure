package practiceAPI;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampPrac {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd a hh:mm")).toString());
        System.out.println(LocalDateTime.now());
    }
}
