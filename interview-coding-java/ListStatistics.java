import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ListStatistics {

    //From a list of integers, find min, max, sum, average, and count
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(7, 6, 4, 4, 8, 10);

       /* int max = number.stream().max(Integer::compareTo).get();
        int min = number.stream().min(Integer::compareTo).get();
        int sum = number.stream().mapToInt(Integer::intValue).sum();
        double average = number.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        Long count = number.stream().count();

        System.out.println("max :" + max);
        System.out.println("min :" + min);
        System.out.println("sum :" + sum);
        System.out.println("average :" + average);
        System.out.println("count :" + count);*/

        IntSummaryStatistics res = number.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("max :" + res.getMax());
        System.out.println("min :" + res.getMin());
        System.out.println("sum :" + res.getSum());
        System.out.println("average :" + res.getAverage());
        System.out.println("count :" + res.getCount());

    }
}
