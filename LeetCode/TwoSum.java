package LeetCode;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSums(int[] nums, int target) {
        HashMap<Integer, Integer> twoSum = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (twoSum.containsKey(complement)) {
                return new int[] { twoSum.get(complement), i };
            }

            twoSum.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        twoSums(nums, target);
    }
}
