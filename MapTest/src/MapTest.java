import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapTest {

    private void initial(Map<String, Integer> m, int v1, int v2) {
        m.put("Key1", v1);
        m.put("Key2", v2);
    }

    private void show_map(Map<String, Integer> m, String name) {
        System.out.println("Map - " + name + " : ");
        for (String key : m.keySet())
            System.out.println(key + " - " + m.get(key));
    }

    private void show_lack(Map<String, Integer> m, String name) {
        Set<Integer> s = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toSet());
        s.removeAll(m.values());
        System.out.println("Map " + name + " is lack of values : " + s);
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();

        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Map<String, Integer> m2 = new HashMap<String, Integer>();
        Map<String, Integer> m3 = new HashMap<String, Integer>();

        mt.initial(m1, 1, 2);
        mt.initial(m2, 1, 3);
        mt.initial(m3, 2, 3);
        mt.show_map(m1, "M1");
        mt.show_map(m2, "M2");
        mt.show_map(m3, "M3");
        mt.show_lack(m1, "M1");
        mt.show_lack(m2, "M2");
        mt.show_lack(m3, "M3");
    }
}
