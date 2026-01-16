import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class findUnion {
    public static void main(String[] args) {
        List<Integer> item1 = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> item2 = Arrays.asList(6, 7, 8,2, 9, 10);

        List<Integer> item3 = Arrays.asList(11, 12,2, 13, 14, 15);

        List<Integer> item4 = Stream.of(item1, item2, item3).flatMap(List::stream).toList();
        System.out.println(item4);

        List<Integer> item5= item4.stream().filter(s-> Collections.frequency(item4,s)>2).distinct().toList();
        System.out.println(item4);
        System.out.println(item5);





    }
}
