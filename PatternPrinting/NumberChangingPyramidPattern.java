package PatternPrinting;

import java.util.Scanner;

public class NumberChangingPyramidPattern {
    public static void main(String[] args) {
        int n;
        int num = 1;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        s.close();
    }
}
