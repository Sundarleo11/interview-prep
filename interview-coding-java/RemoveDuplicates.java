import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Remove duplicates while preserving insertion order
//Remove duplicates without preserving insertion order
public class RemoveDuplicates {

    public static void main(String[] args) {

        List<Integer> RDN= Arrays.asList(1,2,3,4,5,3,4,5,7,8);

        int []arr={1,2,3,4,3,4,2,3,5,67,78};

        List<Character> RDC = Arrays.asList('a', 'b', 'c', 'd', 'e', 'a', 'f');


        //preserving insertion order
         RDN.stream().distinct().forEach(e->System.out.print(" "+e));
        //output: 1 2 3 4 5 7 8

        //Not preserving insertion order
          RDN.stream().collect(Collectors.toSet()).forEach(e->System.out.print(" "+e));
        //output: 1 2 3 4 5 7 8

        //array using below
         Arrays.stream(arr).distinct().forEach(e->System.out.print(" "+e));
        //output:1 2 3 4 5 67 78

        RDC.stream().distinct().forEach(c->System.out.print(" "+c));
        //output: a b c d e f






    }
}
