package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersectValues = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    intersectValues.add(nums2[j]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] values = new int[intersectValues.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = intersectValues.get(i);
        }
        return values;
    }
}
