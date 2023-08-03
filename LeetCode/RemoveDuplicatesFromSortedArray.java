package LeetCode;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (num.contains(nums[i])) {
                continue;
            } else {
                num.add(nums[i]);
                k++;
            }
        }
        for (int i = 0; i < num.size(); i++) {
            nums[i] = num.get(i);
        }
        return k;
        // Or this logic also work

        // int j = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != nums[i - 1]) {
        //         nums[j] = nums[i];
        //         j++;
        //     }
        // }
        // return j;
    }
}
