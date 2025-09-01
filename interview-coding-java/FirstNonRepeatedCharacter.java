import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String str="hello world";

       str.chars().mapToObj(s->(char)s)
               .filter(ch -> ch != ' ')
               .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
               .entrySet().stream().filter(s->s.getValue()==1)
               .forEach((res)->System.out.println("key : "+res.getKey() +" value :"+res.getValue()));

    }
}
