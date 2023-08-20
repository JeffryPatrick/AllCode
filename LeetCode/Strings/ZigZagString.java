package LeetCode.Strings;

import java.util.*;

public class ZigZagString {
    public static void main(String[] args) {
        int numRows;
        Scanner in = new Scanner(System.in);
        numRows = in.nextInt();
        String s = "ABCDEFGH";
        char[][] all = new char[numRows][s.length()];
        int row = 0;
        int col = 0;
        int cur = 0;
        while (cur < s.length()) {
            // used to store the char in row wise
            while (row < numRows && cur < s.length()) {
                all[row++][col] = s.charAt(cur++);
            }
            row = Math.max(0, row - 2);
            while (row > 0 && cur < s.length()) {
                all[row--][++col] = s.charAt(cur++);
            }
            col++;
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (all[i][j] != ' ')
                    ans += all[i][j];
            }
        }
        System.out.println(ans);
    }
}
