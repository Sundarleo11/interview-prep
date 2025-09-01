import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindNthSmallestElement {

    //Find the Nth smallest element in an array using Java Stream
    //Find the Nth largest element in an array using Java Stream
    public static void main(String[] args) {

        List<Integer> num= List.of(2,45,56,1,5,68,9,9,20);

        Optional<Integer> smallest= num.stream().sorted().limit(num.size()-1).findFirst();
        System.out.println("Smallest Number :"+smallest.get());

        Integer largest= num.stream().sorted(Comparator.reverseOrder()).limit(num.size()-1).findFirst().orElse(null);

        System.out.println("Largest Number :"+largest);
    }
}
