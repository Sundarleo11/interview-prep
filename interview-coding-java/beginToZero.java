import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class beginToZero {
    public static void main(String[] args) {
        int arr[] = {0, 5, 69, 0, 3, 4, 0};

        List<Integer> item = Arrays.stream(arr).boxed().toList();

        List<Integer> zero = item.stream().filter(s -> s == 0).toList();
        List<Integer> noon_zero = item.stream().filter(s -> s != 0).toList();

        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(zero);
        finalList.addAll(noon_zero);

        //  System.out.println(finalList);


        List<Integer> ans = Arrays.stream(arr).boxed().sorted((a, b) -> a == 0 ? -1 : 1).toList();
        System.out.println(ans);
    }
}
