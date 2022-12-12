import java.util.function.Supplier;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create a new random number generator
        Random random = new Random();

        // Create a supplier that generates a random integer
        Supplier<Integer> randomIntSupplier = () -> random.nextInt();

        // Use the supplier to generate 10 random numbers
        for (int i = 0; i < 10; i++) {
            System.out.println(randomIntSupplier.get());
        }
    }
}
