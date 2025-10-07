import java.util.Scanner;

public class SearchRotatedSorted {

    private static int SearchRotatedSorted(int arr[],int n){

        for(int i=0;i<arr.length;i++){
            if(n==arr[i]){
                return i;
            }
        }
        return -1;

    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]={4,5,6,7,8,1,23,0};

       System.out.print(SearchRotatedSorted(arr, n));


    }



}
