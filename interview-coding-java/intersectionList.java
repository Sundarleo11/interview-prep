import java.util.Arrays;
import java.util.List;

public class intersectionList {

    public static void main(String[] args) {
        List<Integer> item1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> item2 = Arrays.asList(2, 4, 6, 8, 10, 7);
        List<Integer> item3 = Arrays.asList(2, 4, 8, 10, 6, 7);

        List<Integer> ans1 = item2.stream().filter(item1::contains).filter(item3::contains).toList();

        List<Integer> ans2 = item1.stream()
                .filter(i -> Arrays.asList(item1, item2, item3)
                        .stream()
                        .allMatch(list -> list.contains(i)))
                .toList();


        System.out.println(ans1);

        System.out.println(ans2);

        int[]  list1 = {1, 2, 3, 4, 5, 6, 7};
        int[]  list2 = {2, 4, 6, 8, 10, 7};
        int[]  list3 = {2, 4, 8, 10, 6, 7};

        List<Integer> l2=Arrays.stream(list2).boxed().toList();
        List<Integer> l3=Arrays.stream(list3).boxed().toList();


      List<Integer>l4=  Arrays.stream(list1).boxed().filter(l2::contains).filter(l3::contains).toList();
      System.out.println(l4);

    }
}
