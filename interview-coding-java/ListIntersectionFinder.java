import java.util.List;

public class ListIntersectionFinder {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2, 3, 4, 5);
        List<Integer> l2 = List.of(1, 7, 3, 9, 5);

        l1.stream().filter(l2::contains).forEach(System.out::println);
    }
}
