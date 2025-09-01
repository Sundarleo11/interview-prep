import java.util.Arrays;
import java.util.Collections;

public class FirstOddNumberFinder {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 8, 10};

        int arr2[] = Arrays.stream(arr).filter(e -> e % 2 == 1).toArray();
        System.out.println(Arrays.toString(arr2));
    }
}
