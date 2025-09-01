import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ElementFrequencyCounter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange","orange", "banana", "apple");

        words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        /*
        orange : 1
        banana : 2
        apple : 3
         */

        //need output like:[orange] : 1
        //[banana, apple] : 2

        // Step 1: Count frequency of each word
        Map<String, Long> wordCounts = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, List<String>> res =wordCounts.entrySet()
                .stream()
                .collect(Collectors.groupingBy( Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())));
        System.out.println(""+res);


    }
}
