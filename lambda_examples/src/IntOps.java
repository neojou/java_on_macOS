import java.util.Map;
import java.util.function.BinaryOperator;

public class IntOps {
    private Map<String, BinaryOperator<Integer>> table =
            Map.of(
                    "add", (x, y) -> x + y,
                    "sbustract", (x, y) -> x - y
            );


    public int eval(String op, int x, int y) {
        return table.get(op).apply(x, y);
    }
}
