package practiceAPI;

import java.util.UUID;

public class UuidPrac {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            UUID uid = UUID.randomUUID();
            System.out.println(uid);
        }

        String uuid = "https://sallestorage.s3.ap-northeast-2.amazonaws.com/";
        System.out.println(uuid.length());
    }
}
