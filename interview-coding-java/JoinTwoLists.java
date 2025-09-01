import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JoinTwoLists {

    public static void main(String[] args) {

        //take it array List

        List<Integer>l1= Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer>l2=Arrays.asList(11,12,13,14,15,16,17,18,19);

        //take it array Integer

        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};


        //take it array Int
        int[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ar2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};


        Stream.concat(l1.stream(),l2.stream()).distinct().forEach(e->System.out.print(" "+e));

        Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().forEach(e->System.out.print(" "+e));

        IntStream.concat(Arrays.stream(ar1), Arrays.stream(ar2)).distinct().forEach(e->System.out.print(" "+e));

        //output: 1 2 3 4 5 6 7 8 9 11 12 13 14 15 16 17 18 19


    }
}
