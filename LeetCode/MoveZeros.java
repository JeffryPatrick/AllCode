package LeetCode;

public class MoveZeros {
    public static void movezeros(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - zeroCount] = t;
            }
        }
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
