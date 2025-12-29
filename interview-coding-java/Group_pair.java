import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Group_pair {
    public static void main(String[] args) {
        String arr[]={"pat","tap","pan","nap","Team","tree","meet"};

       Map<String, List<String>> anagram= Arrays.stream(arr).collect(Collectors.groupingBy(word->
        {
          char charcter[] = word.toLowerCase().toCharArray();
          Arrays.sort(charcter);
          return new String(charcter);
        }));

      // group.forEach((k,v)->System.out.print(k+" "));
        anagram.values().forEach(System.out::println);
    }
}
