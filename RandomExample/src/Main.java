
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.function.IntUnaryOperator;
import java.util.IntSummaryStatistics;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int r;

        // Math.random()
        for (int i = 0; i < 10; i++) {
            r = (int)(Math.random()*(100 - 10 + 1)) + 10;
            System.out.print(" " + r);
        }
        System.out.println();

        // Random
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            r = 10 + rnd.nextInt(100 - 10 + 1);
            System.out.print(" " + r);
        }
        System.out.println();

        // ThreadLocalRandom
        for (int i = 0; i < 10; i++) {
            r = 10 + ThreadLocalRandom.current().nextInt(100 - 10 + 1);
            System.out.print(" " + r);
        }
        System.out.println();

        // SecureRandom
        try {
            SecureRandom srnd = SecureRandom.getInstance("NativePRNGNonBlocking");
            System.out.println("current random algorithm = " + srnd.getAlgorithm());
            for (int i = 0; i < 10; i++) {
                r = 10 + srnd.nextInt(100 - 10 + 1);
                System.out.print(" " + r);
            }
            System.out.println();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}