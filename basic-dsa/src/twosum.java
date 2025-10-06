import java.util.Arrays;
import java.util.HashMap;

public class twosum {

    public  static int[] Twosum(int []nums,int target){

        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
        //Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:Because nums[0] + nums[1] == 9, we return [0, 1].
        int nums[]={2,7,11,15};
        int target=9;
        int [] result=Twosum(nums,target);
        System.out.print(Arrays.toString(result));
    }
}
