
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    public static void test(Stream<String> s) {
        List<String> slist = s.collect(Collectors.toList());
        System.out.println(slist.size());

        Stream<String> s1 = slist.stream();
        Supplier<Stream<String>> streamSupplier = () -> s1;

        final AtomicInteger counter = new AtomicInteger();
        streamSupplier.get().parallel()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 2))
                .values()
                .stream()
                .forEach(input -> {
                    System.out.println("input " + input);
                });
    }

    public static void main(String[] args) {
        IntStream nums = IntStream.rangeClosed(1, 10);
        Stream<String> ss = nums.mapToObj(i -> Integer.toString(i));
        test(ss);
    }


    private void example() {
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
