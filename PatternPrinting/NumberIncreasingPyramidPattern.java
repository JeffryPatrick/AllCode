package PatternPrinting;

import java.util.Scanner;

public class NumberIncreasingPyramidPattern {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        s.close();
    }
}

/* Number Increasing Pyramid Pattern */
/*
 * 1
 * 12
 * 123
 * 1234
 * 12345
 * 123456
 */