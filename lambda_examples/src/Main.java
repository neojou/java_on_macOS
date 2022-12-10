
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) {
        List<String> greetings = List.of("Hello", "Hi", "How're you doing");
        List<String> names = List.of("world", "everyone", "Asuna", "Kirito");

        BinaryOperator<String> whenMeetsSay = (greeting, name) -> greeting + " " + name + "!";
        String search_name = "world";
        Callable<String> cb_r = () -> {
            names.stream()
                    .filter(s -> s.equalsIgnoreCase(search_name))
                    .forEach((name) -> System.out.println(
                            whenMeetsSay.apply(
                                    greetings.get(
                                            new Random().nextInt(greetings.size())),
                                    name)));
            return "OK";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(cb_r);
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println("execute result:" + result);

        IntOps a = new IntOps();
        int sum = a.eval("add", 2, 3);
        System.out.println("2 + 3 = " + sum);
    }
}