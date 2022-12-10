
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        List<String> greetings = List.of("Hello", "Hi", "How're you doing");
        List<String> names = List.of("world", "everyone", "Asuna", "Kirito");

        BinaryOperator<String> whenMeetsSay = (greeting, name) -> greeting + " " + name + "!";
        String search_name = "world";
        Runnable r = () -> names.stream()
                                .filter(s -> s.equalsIgnoreCase(search_name))
                                .forEach((name) -> System.out.println(
                                        whenMeetsSay.apply(
                                                greetings.get(
                                                    new Random().nextInt(greetings.size())),
                                                name)));
        new Thread(r).start();

        IntOps a = new IntOps();
        int sum = a.eval("add", 2, 3);
        System.out.println("2 + 3 = " + sum);
    }
}