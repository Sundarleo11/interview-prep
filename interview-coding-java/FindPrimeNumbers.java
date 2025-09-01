import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//prime number find given list
public class FindPrimeNumbers {

    public static void main(String[] args) {
        List<Integer> prime = Arrays.asList(7, 6, 4, 4, 8, 10);

        //boolean res = prime.stream().anyMatch(FindPrimeNumbers::isprime);
        //System.out.println("is prime of :" + res);

        prime.stream().filter(FindPrimeNumbers::isprime).forEach(e -> System.out.println(" " + e));


    }


    public static boolean isprime(Integer a) {
        if (a <= 1) return false;

      /*
       java 7 logic
      for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;*/

        // lets go for java 8

        return IntStream.rangeClosed(2, (int) Math.sqrt(a))
                .noneMatch(e -> a % e == 0);


    }
}
