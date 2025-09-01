import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWord {
    public static void main(String[] args) {
        String str = "abcde  test application";
        String word = "abcde";

        // 🔹 Example 1: Reverse each word in a sentence
        // String response = Arrays.stream(str.split(" "))
        //                         .map(w -> new StringBuffer(w).reverse())
        //                         .collect(Collectors.joining(" "));
        // System.out.println(response);

        // 🔹 Example 2: Reverse using IntStream
        String str2 = IntStream.range(0, word.length())
                .mapToObj(i -> String.valueOf(word.charAt(word.length() - 1 - i)))
                .collect(Collectors.joining(""));

        // 🔹 Example 3: Reverse using reduce
        String str3 = word.chars()
                .mapToObj(s -> String.valueOf((char) s))
                .reduce("", (a, b) -> b + a);

        // 🔹 Output
        System.out.println("Using IntStream  : " + str2);
        System.out.println("Using Reduce     : " + str3);
    }
}
