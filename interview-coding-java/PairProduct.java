import java.util.stream.IntStream;

public class PairProduct {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 10, 12};
        int target = 60;

        IntStream.range(0, arr.length)
                 .boxed()
                 .flatMap(i -> IntStream.range(i + 1, arr.length)
                                        .filter(j -> arr[i] * arr[j] == target)
                                        .mapToObj(j -> arr[i] + " * " + arr[j] + " = " + target))
                 .forEach(System.out::println);

                 //or
    IntStream.range(0, arr.length).distinct() .forEach(i -> IntStream.range(i + 1, arr.length) .filter(j -> arr[i] * arr[j] == target) .forEach(j -> System.out.println("Pair: " + arr[i] + " : " + arr[j])));

    }
    
}
