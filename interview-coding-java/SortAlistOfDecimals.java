import java.util.Comparator;
import java.util.List;

public class SortAlistOfDecimals {
    public static void main(String[] args) {
        List<Double> DR= List.of(22.2,23.4,55.7,7.8,66.8);

        //revers the order
         DR.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //natural sort
        DR.stream().sorted().forEach(System.out::println);

    }
}
