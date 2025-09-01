import java.util.List;

public class SumOfFirstTwoNumbers {

    //Find the sum of the first two numbers in a list

    //Find the sum of unique numbers in a list
    public static void main(String[] args) {


        List<Integer> num= List.of(2,45,56,1,45,5,68,9,9,20,22);
        Integer sum=num.stream().limit(2).mapToInt(Integer::intValue).sum();
        System.out.println("sum of the first two numbers :"+sum);

        Integer uniqueSum=num.stream().distinct().mapToInt(Integer::intValue).sum();

        System.out.println("sum of unique numbers in a list :"+uniqueSum);
    }
}
