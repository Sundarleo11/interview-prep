import java.util.Comparator;
import java.util.List;

public class ThirdLongestWord {

    //Find the word with the third highest length
    public static void main(String[] args) {

        List<String> str = List.of("abc", "abcd", "abcde", "abvcfsg");

        String res = str.stream()
               // .sorted(Comparator.comparingInt(String::length).reversed())
                .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))  //reversed
                .skip(2).findFirst().get();

        System.out.println("third highest length :" + res);

    }
}
