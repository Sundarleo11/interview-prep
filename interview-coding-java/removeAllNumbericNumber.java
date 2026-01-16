import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.List;

public class removeAllNumbericNumber {
    public static void main(String[] args) {
        List<String> item = Arrays.asList("abc12b45", "234uyio", "ghbj89");


        List<String> numericalValue = item.stream().map(s -> s.replaceAll("\\d", "")).toList();

        List<String> listOfString = item.stream().map(s -> s.replaceAll("\\D", "")).toList();

        System.out.println(numericalValue);

        System.out.println(listOfString);
    }
}
