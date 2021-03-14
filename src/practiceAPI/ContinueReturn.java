package practiceAPI;

public class ContinueReturn {

    public static void main(String[] args) {
        testingContinue();
        testingReturn();
        testingBreak();
        }

    public static void testingContinue() {
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                continue;
            System.out.println(i);
        }
        System.out.println("end");
    }

    public static void testingReturn() {
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                return;
            System.out.println(i);
        }
        System.out.println("end");
    }

    public static void testingBreak() {
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                break;
            System.out.println(i);
        }
        System.out.println("end");
    }
}
