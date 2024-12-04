import java.util.Random;

public class Choice {
    public static int choose() {
        Random random = new Random();
        return random.nextInt(6);
    }
}
