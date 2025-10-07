import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianTwoSortedArrays {

    private static double mergeTwosort(int []num1,int []num2){


        int arr[]= IntStream.concat(Arrays.stream(num1), Arrays.stream(num2)).sorted().toArray();

        int size=arr.length;
        if(size/2==1){
            return arr[size/2];
        }else{
            return arr[size/2-1]+arr[size/2]/2.0;
        }

    }
    public static void main(String[] args) {

        int []nums1 = {1,3}, nums2 = {2};
        double result= mergeTwosort(nums1, nums2);
        System.out.print(result);

    }

    /*
    Median of Two Sorted Arrays
    Given two sorted arrays nums1 and nums2 of size m and n
    respectively, return the median of the two sorted arrays.4. Search in Rotated Sorted ArrayGiven the array nums after the possible rotation and an integertarget, return the index of the target if it is in nums, or -1 if it isnot in nums.
    The overall run time complexity should be O(log (m+n)).
    Input:
    nums1 = [1,3], nums2 = [2]
    Output
   : 2.00000
    Explanation
    : merged array = [1,2,3] and the median is 2.
     */
}
