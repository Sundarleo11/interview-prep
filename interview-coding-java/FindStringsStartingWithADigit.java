import java.util.Arrays;
import java.util.List;

public class FindStringsStartingWithADigit {

    //Find strings starting with a digit using
    public static void main(String[] args) {

        List<String> words = Arrays.asList("123apple", "banana", "9lives", "orange", "42isTheAnswer", "grape", "7up", "apple123");

        //words.stream().filter(e -> !e.isEmpty() && Character.isDigit(e.charAt(0))).forEach(System.out::println);
        /*
        123apple
        9lives
        42isTheAnswer
        7up
         */

        //RemoveStartingNumber
        words.stream().map(e -> Character.isDigit(e.charAt(0)) ? e.replaceAll("^[0-9]+", "") : e).forEach(System.out::println);


        //StartingFirstCharto uppercase
        List<String> FSU = Arrays.asList("aPPLE", "banana", "lIVES", "Orange");
        FSU.stream().map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1)).forEach(word -> System.out.println(" " + word));

        /*
        APPLE
        Banana
        LIVES
        Orange
         */
    }
}
