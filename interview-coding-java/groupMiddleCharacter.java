import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupMiddleCharacter {
    public static void main(String[] args) {
        List<String> item= Arrays.asList("abc","bcd","ewe","jji","jhj","kwe");

       Map<String,List<String>> ans= item.stream().collect(Collectors.groupingBy(x-> String.valueOf(x.toString().substring(1,2))));
       System.out.println(ans);
    }
}
