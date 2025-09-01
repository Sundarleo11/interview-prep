import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithBrackets {
    public static void main(String[] args) {
        List<String> str = List.of("abc", "cde", "edfr");

        String JoinStringsWithBrackets = str.stream().map(s -> "[" + s + "]").collect(Collectors.joining(","));

        System.out.println("JoinStringsWithBrackets :" + JoinStringsWithBrackets);
        //JoinStringsWithBrackets :[abc],[cde],[edfr]

        String JoinWithBrackets = str.stream().collect(Collectors.joining(",", "[", "]"));

        System.out.println("JoinWithBrackets" + JoinWithBrackets);

        //JoinWithBrackets[abc,cde,edfr]

    }
}
