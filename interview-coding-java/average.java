import java.util.Arrays;
import java.util.List;

public class average {
    public static void main(String[] args) {
        List<Integer> item = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        double avg = item.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(avg);
    }
}
