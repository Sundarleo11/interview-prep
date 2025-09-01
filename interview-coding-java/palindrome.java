import java.util.stream.IntStream;

public class palindrome {
    public static void main(String[] args) {
        String str="madams";


       boolean palindrome=IntStream.range(0,str.length()/2).allMatch(i-> str.charAt(i)==str.charAt(str.length()-i-1));



       /* boolean palindrome=true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                palindrome=false;
            }
        }

        System.out.println( palindrome ? "is palindrome" : "is not palindrome");*/
        System.out.println( palindrome ? "is palindrome" : "is not palindrome");

    }
}
