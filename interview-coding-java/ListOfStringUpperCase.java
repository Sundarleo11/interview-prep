import java.util.Arrays;
import java.util.List;

public class ListOfStringUpperCase {

    public static void main(String[] args) {
        List<String> item = Arrays.asList("a", "b", "c", "d");

        List<String> ans = item.stream().map(String::toUpperCase).toList();

        System.out.println(ans);

        // ans must be single string A, B, C, D
         String res=item.stream().map(String::toUpperCase).reduce((a,b)->a+" "+b).get();
         System.out.println(res);

    }
}
