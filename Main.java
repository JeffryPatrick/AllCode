import LeetCode.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Plus One
         * int[] digit1 = { 1, 2, 3 };
         * int[] digit2 = { 1, 2, 9 };
         * int[] digit3 = { 9, 9, 9 };
         * int[] answer = PlusOne.digitOne(digit1);
         * for (int i : answer) {
         * System.out.print(i);
         * }
         * System.out.println();
         * answer = PlusOne.digitOne(digit2);
         * for (int i : answer) {
         * System.out.print(i);
         * }
         * System.out.println();
         * answer = PlusOne.digitOne(digit3);
         * for (int i : answer) {
         * System.out.print(i);
         * }
         */

        /*
         * Longest Prefix Character
         * String[] strs = { "flower", "flow", "flight" };
         * String[] str1 = { "dog", "racecar", "car" };
         * String answer1 = LongestCommonPrefix.longestPrefix(strs);
         * String answer2 = LongestCommonPrefix.longestPrefix(str1);
         * System.out.println(answer1);
         * System.out.println(answer2);
         */

        // System.out.println(PascalTriangle.generate(5));

        int[] nums = { 1, 1, 2 };
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int ans = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        System.out.println(ans);
        ans = RemoveDuplicatesFromSortedArray.removeDuplicates(nums2);
        System.out.println(ans);
    }
}
