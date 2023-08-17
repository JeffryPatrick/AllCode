package PatternPrinting;

import java.util.Scanner;

public class XOPattern {
    public static void main(String[] args) {
        // int m, n;
        // Scanner s = new Scanner(System.in);
        // m = s.nextInt();
        // n = s.nextInt();
        // for (int i = 1; i <= m; i++) {
        // for (int j = 1; j <= n; j++) {
        // if (i == 1 || i == m || j == 1|| j == n ) {
        // System.out.print("X");
        // } else {
        // System.out.print("O");
        // }
        // }
        // System.out.println();
        // }

        // int[][] mat = {
        // { 1, 2, 3, 4 },
        // { 14, 15, 16, 5 },
        // { 13, 20, 17, 6 },
        // { 12, 19, 18, 7 },
        // { 11, 10, 9, 8 }
        // };

        // int rowStart = 0, rowEnd = mat.length;
        // int colStart = 0, colEnd = mat[0].length;

        // while (rowStart < rowEnd && colStart < colEnd) {
        // // print top row left->right
        // for (int i = colStart; i < colEnd; i++) {
        // System.out.print(mat[rowStart][i] + " ");
        // }

        // rowStart += 1;

        // // print top->bottom
        // for (int i = rowStart; i < rowEnd; i++) {
        // System.out.print(mat[i][colEnd - 1] + " ");
        // }

        // colEnd -= 1;

        // // print bottom right to left
        // for (int i = colEnd - 1; i >= colStart; i--) {
        // System.out.print(mat[rowEnd - 1][i] + " ");
        // }

        // rowEnd -= 1;

        // // print left bottom to top

        // for (int i = rowEnd - 1; i >= rowStart; i--) {
        // System.out.print(mat[i][colStart] + " ");
        // }

        // colStart += 1;
        // }

        char c = 'X';
        int m, n;
        try (Scanner s = new Scanner(System.in)) {
            m = s.nextInt();
            n = s.nextInt();
        }
        char[][] mat = new char[m][n];
        int rowStart = 0, rowEnd = mat.length;
        int colStart = 0, colEnd = mat[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {

            for (int i = colStart; i < colEnd; i++) {
                mat[rowStart][i] = c;
            }

            rowStart += 1;

            for (int i = rowStart; i < rowEnd; i++) {
                mat[i][colEnd - 1] = c;
            }

            colEnd -= 1;

            for (int i = colEnd; i >= colStart; i--) {
                mat[rowEnd - 1][i] = c;
            }

            rowEnd -= 1;

            for (int i = rowEnd - 1; i >= rowStart; i--) {
                mat[i][colStart] = c;
            }

            colStart += 1;

            c = (c == 'O') ? 'X' : 'O';
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }
}
