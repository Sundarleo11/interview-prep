import java.util.Arrays;
import java.util.List;

public class FindNumbersStarting {

    //Find numbers starting with digit number (maybe any number like 1 or 2)
    //Find the List of number start with s
    public static void main(String[] args) {

        List<Integer> FN= Arrays.asList(1,2,3,4,11,21,13,45);

        List<String> FW = Arrays.asList("sun", "apple", "sky", "stone", "banana", "sea", "start", "end");



        FN.stream().filter(n->String.valueOf(n).startsWith("1")).forEach(e->System.out.print(" "+e));
        //1 11 13

        FW.stream().filter(s->s.startsWith("s")).forEach(e->System.out.print(" "+e));
        //sun sky stone sea start

    }
}
