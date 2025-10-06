import java.util.Arrays;

public class ProductArrayExceptSelf {


    public static int[] ProductArray(int[] nums) {

        int[] answer = new int[nums.length];

        int prefix = 1;
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }
        return answer;


    }

    public static void main(String[] args) {
        /*answer[i] = product of all nums[j] where j ≠ i
        nums = [1, 2, 3, 4]
        answer = [24, 12, 8, 6]

        For index 0: product of [2×3×4] = 24

        For index 1: product of [1×3×4] = 12

        For index 2: product of [1×2×4] = 8

        For index 3: product of [1×2×3] = 6*/

        int[] nums = {1, 2, 3, 4};
        int[] result = ProductArray(nums);

        System.out.print(Arrays.toString(result));

    }
}
