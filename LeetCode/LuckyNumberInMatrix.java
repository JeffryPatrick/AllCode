package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumberInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mi = new int[m], mx = new int[n];
        Arrays.fill(mi, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mi[i] = Math.min(matrix[i][j], mi[i]);
                mx[j] = Math.max(matrix[i][j], mx[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(mi[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(mx[i] + " ");
        }
        System.out.println();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mi[i] == mx[j]) {
                    res.add(mi[i]);
                    break;
                }
            }
        }
        return res;
    }
}
