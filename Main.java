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
         * 
         * String[] strs = { "flower", "flow", "flight" };
         * String[] str1 = { "dog", "racecar", "car" };
         * String answer1 = LongestCommonPrefix.longestPrefix(strs);
         * String answer2 = LongestCommonPrefix.longestPrefix(str1);
         * System.out.println(answer1);
         * System.out.println(answer2);
         * 
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
        // int[] arr = { 1, 8, 3, 4, 5, 6, 7, 2, 9 };
        // for (int i = 0; i < arr.length; i++) {
        // int j = 0;
        // while (j < arr.length - 1) {
        // if (arr[j] < arr[j + 2]) {
        // int t = arr[j];
        // arr[j] = arr[j + 2];
        // arr[j + 2] = t;
        // }
        // j += 2;
        // }
        // int k = 1;
        // while (k < arr.length - 2) {
        // if (arr[k] > arr[k + 2]) {
        // int t = arr[k];
        // arr[k] = arr[k + 2];
        // arr[k + 2] = t;
        // }
        // k += 2;
        // }
        // }
        // System.out.println();
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // String s = "jeffrypatrick";
        // for (int i = 0; i < s.length(); i++) {
        // for (int j = 0; j < s.length(); j++) {
        // if (i == j || j == s.length() - i - 1) {
        // System.out.print(s.charAt(j));
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }
        // int d = 4658;
        // String q = String.valueOf(d);
        // int e = 8563 + Integer.parseInt(q);
        // System.out.println(e);

        // System.out.println();

        // int mat[][] = { { 6, 5, 4 }, { 1, 2, 5 }, { 7, 9, 7 } };

        // int up = 0, low = 0;
        // for (int i = 0; i < 3; i++) {
        // for (int j = 0; j < 3; j++) {
        // if (j <= i)
        // low += mat[i][j];
        // if (i <= j)
        // up += mat[i][j];
        // }
        // }
        // System.out.println(up);
        // System.out.println(low);

        // int m[][] = {
        // { 3, 5, 4, 2 },
        // { 2, 4, 5 },
        // { 4, 5, 6, 7, 8 },
        // { 4, 9, 2, 1 },
        // { 1, 2 },
        // };

        // int sum = 0;
        // String sa = "";
        // for (int i = 0; i < m.length; i++) {
        // sa = "";
        // for (int j = 0; j < m[i].length; j++) {
        // sa += String.valueOf(m[i][j]);
        // }
        // sum += Integer.parseInt(sa);
        // }
        // System.out.println(sum);

        // for (int i = 1; i <= 5; i++) {
        // for (int j = 1; j <= 5; j++) {
        // if (i == j || j == 5 - i + 1) {
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

        // int[] nums1 = { 9, 8, 7, 61, 4 };
        // int[] nums2 = { 4, 8, 9, 9, 4 };
        // int[] nums3 = IntersectionOfTwoArrays.intersect(nums1, nums2);
        // for (int x : nums3) {
        // System.out.println(x);
        // }

        // int mat[][] = { { 1, 2, 3, 4, 6 }, { 5, 3, 8, 1, 2 }, { 4, 6, 7, 5, 5 }, {
        // 2, 4, 8, 9, 4 } };
        // int index[] = { 2, 0, 3, 4 };
        // int sum = 0;
        // for (int i = index[0]; i < mat.length; i++) {
        // for (int j = index[1]; j < mat[i].length; j++) {
        // System.out.print(mat[i][j] + " ");
        // sum += mat[i][j];
        // }
        // System.out.println();
        // }
        // System.out.println(sum);

        // String s = "He did a good deed";
        // String[] st = s.split(" ");
        // for (int i = 0; i < st.length; i++) {
        // if (!Main.pal(st[i])) {
        // System.out.print(st[i] + " ");
        // }
        // }

        // int year = 2024;
        // if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
        // System.out.println("t");
        // else
        // System.out.println("f");

        // for (int i = 1; i <= 5; i++) {
        // for (int j = i; j <= 5; j++) {
        // System.out.print(j);
        // }
        // for (int k = 1; k < i; k++) {
        // System.out.print(k);
        // }
        // System.out.println();
        // }

        // int[][] mat = { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } };
        // List<Integer> ans = new LuckyNumberInMatrix().luckyNumbers(mat);
        // System.out.println(ans);

        // tring s = " fly me to the moon ";
        // int count = 0;
        // s = s.trim();
        // for (int i = s.length() - 1; i >= 0; i--) {
        // if (s.charAt(i) != ' ') {
        // count += 1;

        // }
        // else {
        // break;
        // }
        // }
        // System.out.println(count);

        // int ar[] = { 1, 2, 4, 7 };
        // int target = 8;

        // int low = 0;
        // int high = ar.length - 1;
        // int mid = 0;
        // while (low <= high) {
        // mid = (low + high) / 2;
        // if (ar[mid] > target) {
        // high = mid - 1;
        // } else if (ar[mid] < target) {
        // low = mid + 1;
        // } else {
        // System.out.println(mid);
        // }
        // }
        // System.out.println(low);

        /*
         * first Unique Character
         */
        // String s = "leetcode";
        // int i = FirstUniqueCharInString.firstUniqChar(s);
        // System.out.println(i);

        /*
         * Reverse string
         * 
         * char[] s = { 'h', 'e', 'l', 'l', 'o' };
         * char[] ans = ReverseString.reverseString(s);
         * for (char c : ans) {
         * System.out.println(c);
         * }
         * 
         */

        /*
         * Fizz Buzz
         * 
         * List<String> answer = new ArrayList<>();
         * answer = FizzBuzz.fizzBuzz(15);
         * for (String string : answer) {
         * System.out.println(string);
         * }
         * 
         */

        

        // if (ar[mid] > target) {
        // high = mid - 1;
        // } else if (ar[mid] < target) {
        // low = mid + 1;
        // } else {
        // System.out.println(mid);
        // }
        // }
        // System.out.println(low);

        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase();
        String ans = "";
        Character.isAlphabetic('d');  
    }

    public static boolean pal(String s) {
        String a = "";
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            a += s.charAt(i);
        }
        if (s.equals(a))
            return true;
        else
            return false;
    }
}
