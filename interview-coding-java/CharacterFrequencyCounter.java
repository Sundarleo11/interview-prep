import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        String str="hello world";

        str.chars().mapToObj(c->(char)c).filter(c->c!=' ').collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((v,k)->System.out.println(v +"="+ k));
    }
}
