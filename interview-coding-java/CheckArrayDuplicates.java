import java.util.Arrays;

public class CheckArrayDuplicates {

    //Check if an array contains duplicate elements
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,2};

      Long count=  Arrays.stream(arr).distinct().count();

        if(count!=arr.length){
            System.out.println("is duplicate");
        }else{
            System.out.println("is not duplicate");
        }
    }
}
