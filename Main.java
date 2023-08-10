import java.util.ArrayList;
import java.util.List;

import LeetCode.*;

public class Main {
    public static void main(String[] args) {

        // int[] digit1 = { 1, 2, 3 };
        // int[] digit2 = { 1, 2, 9 };
        // int[] digit3 = { 9, 9, 9 };
        // int[] answer = PlusOne.digitOne(digit1);
        // for (int i : answer) {
        // System.out.print(i);
        // }
        // System.out.println();
        // answer = PlusOne.digitOne(digit2);
        // for (int i : answer) {
        // System.out.print(i);
        // }
        // System.out.println();
        // answer = PlusOne.digitOne(digit3);
        // for (int i : answer) {
        // System.out.print(i);
        // }

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

        // int[] nums = { 1, 1, 2 };
        // int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        // int ans = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        // System.out.println(ans);
        // ans = RemoveDuplicatesFromSortedArray.removeDuplicates(nums2);
        // System.out.println(ans);

        // String haystack = "leetcode";
        // String needle = "code";
        // System.out.println(FindIndexOfFirstOccurenceInString.strstr(haystack,
        // needle));
        // haystack = "sadbutsad";
        // needle = "sad";
        // System.out.println(FindIndexOfFirstOccurenceInString.strstr(haystack,
        // needle));

        // TicTacToeGame.startGame();

        // int row = 1, col = 1;

        // for (row = 1; row <= 5; row++) {
        // for (col = 1; col <= 5; col++) {
        // if (col == row || col == 5 - row + 1) {
        // System.out.print("*");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }

        // String s = "07:05:45PM";
        // String fmt = s.substring(s.length() - 2, s.length());
        // String hr = s.substring(0, 2);
        // String sub = s.substring(2, s.length() - 2);
        // String hr_24 = "";
        // if (fmt.equals("AM")) {
        // hr = hr.replace("12", "00");
        // hr_24 = hr + sub;
        // } else if (fmt.equals("PM")) {
        // int val = 0;
        // if (hr.equals("12")) {
        // hr_24 = hr + sub;
        // } else {
        // val = Integer.parseInt(hr);
        // val = val + 12;
        // hr_24 = String.valueOf(val) + sub;
        // }
        // }
        // System.out.println(hr_24);

        // int[] nums = { 0, 1, 0, 3, 12 };
        // MoveZeros.movezeros(nums);

        int[] nums1 = { 9, 8, 7, 61, 4 };
        int[] nums2 = { 4, 8, 9, 9, 4 };
        int[] nums3 = IntersectionOfTwoArrays.intersect(nums1, nums2);
        for (int x : nums3) {
            System.out.println(x);
        }

    }
}
