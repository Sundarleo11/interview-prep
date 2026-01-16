import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class containsDistinctValues {

    public static void main(String[] args) {
        int arr[]={5,4,1,0,8,2};

        List<Integer> item=  Arrays.stream(arr).boxed().toList();

     Boolean ans= item.stream().collect(Collectors.groupingBy(c->c,Collectors.counting())).values()
                .stream().noneMatch(s->s>1);
     System.out.println(ans);
    }
}
