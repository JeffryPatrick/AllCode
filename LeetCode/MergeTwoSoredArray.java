package LeetCode;

import java.util.*;

public class MergeTwoSoredArray {
    public static void main(String[] args) {
        int m, n;
        int i = 0;
        int j = 0;
        int k = 0;
        System.out.println("Enter M and N : ");
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        int[] c = new int[m + n];
        System.out.println("Enter the elements for A : ");
        for (i = 0; i < m; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Enter the elements for B : ");
        for (i = 0; i < n; i++) {
            b[i] = s.nextInt();
        }

        i = 0;
        j = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < m) {
            c[k++] = a[i++];
        }
        while (j < n) {
            c[k++] = b[j++];
        }

        // display the elements
        for (int l = 0; l < m + n; l++) {
            System.out.print(c[l] + " ");
        }
    }
}
