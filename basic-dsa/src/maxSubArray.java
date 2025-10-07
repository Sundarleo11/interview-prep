public class maxSubArray {


    private static  int maxsubArray(int []num){

        int maxNumber=num[0];
        int currentSum=0;

        for(int n:num){
            currentSum+=n;
            maxNumber=Math.max(maxNumber,currentSum);
            if(currentSum<0){
                currentSum=0;
            }
        }

        return maxNumber;
    }
    public static void main(String[] args) {

        //Using Kadane’s Algorithm)

        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
       System.out.print(maxsubArray(nums));


    }
}
