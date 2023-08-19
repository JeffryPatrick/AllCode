package PatternPrinting;

import java.util.Scanner;

/**
 * SquareHollowPattern
 */
public class SquareHollowPattern {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i == 1 || j == 1 || i == n || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        s.close();
    }

}

/* Square Hollow Pattern */
/*
 * ******
 * * *
 * * *
 * * *
 * * *
 * ******
 */