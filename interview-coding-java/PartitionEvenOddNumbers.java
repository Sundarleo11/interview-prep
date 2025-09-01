import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEvenOddNumbers {

    //Partition a list of numbers into even and odd groups
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        Map<Boolean, List<Integer>> result = Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println(result.get(true));

    }
}
