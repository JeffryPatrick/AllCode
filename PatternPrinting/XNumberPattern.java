package PatternPrinting;

import java.util.Scanner;

public class XNumberPattern {
    public static void main(String[] args) {
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

        int n, m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || j == n - i + 1) {
                    if (i < m) {
                        System.out.print(n - j + 1);
                    } else {
                        System.out.print(j);
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

/* XNumber Pattern */
/*
 * 5   1
 *  4 2
 *   3
 *  2 4
 * 1   5
 */