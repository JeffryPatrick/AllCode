package PatternPrinting;

import java.util.Scanner;

public class NumberIncreasingReversePyramidPattern {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        s.close();
    }
}
