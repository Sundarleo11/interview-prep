import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

public class containesOnlyDigits {

    public static void main(String[] args) {
        List<String> item = Arrays.asList("1234", "123abc", "456", "manus");

        //print only digits
        List<String> digits = item.stream().filter(s -> s.matches("^[0-9]+")).toList();

        List<String> word = item.stream().filter(s -> s.matches("\\D+")).toList();
        List<String> mixed=item.stream().filter(s-> s.chars().anyMatch(Character::isDigit) &&  s.chars().anyMatch(Character::isLetter)).toList();

        System.out.println(digits);

        System.out.println(word);

        System.out.println(mixed);

    }
}
