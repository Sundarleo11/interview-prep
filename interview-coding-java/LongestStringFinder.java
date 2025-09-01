import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringFinder {

    //Find the longest string in a list using Java Stream
    public static void main(String[] args) {
        List<String> FW = Arrays.asList("sun", "apple", "sky", "stone", "banana", "sea", "start", "end");

       String res= String.valueOf(FW.stream().max(Comparator.comparingInt(String::length)));
       System.out.print(" "+res);

        FW.stream()
                .sorted((w1, w2) -> Integer.compare(w1.length(), w2.length())) // descending order
                .forEach(System.out::println);
    }
}
