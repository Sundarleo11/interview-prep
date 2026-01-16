import java.util.List;
import java.util.stream.Stream;

public class fibonacci {
    public static void main(String[] args) {

        int n = 5;
        List<Integer> fib = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .map(t -> t[0])
                .limit(n)
                .toList();
        System.out.println(fib);
    }
}
