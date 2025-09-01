import java.util.List;

public class GetLastElementOfArray {

    //Get the last element of an array
    public static void main(String[] args) {
        List<Integer> num= List.of(2,45,56,1,5,68,9,9,20);

        Integer lastElement=num.stream().skip(num.size()-1).findFirst().get();
        System.out.println("lastElement :"+lastElement);
    }
}
