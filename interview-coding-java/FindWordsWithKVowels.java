import java.util.Arrays;
import java.util.stream.Collectors;

public class FindWordsWithKVowels {

    public static void main(String[] args) {
        String str = "Helloi world";

       int k=2;
         /* str.toLowerCase().chars()
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .forEach(ch -> System.out.print((char) ch + " "));*/

        String result =   Arrays.stream(str.split(" ")).filter(word->help(word)>=k)
                .collect(Collectors.joining( " "));
        System.out.println("Words with at least " + k + " vowels: " + result);




    }

    private static int help(String word){

        return (int) word.toLowerCase().chars().filter(s->"aeio".indexOf(s)!=-1).count();
    }
}
