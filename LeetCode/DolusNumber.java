package LeetCode;

import java.util.Scanner;

public class DolusNumber {
    public static void main(String[] args) {
        int num;
        boolean flag = false, dolus = false;
        Scanner s = new Scanner(System.in);
        num = s.nextInt();
        // num is prime factor or not
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                flag = true;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    if (i == 2 || i == 3 || i == 5) {
                        dolus = true;
                    } else {
                        dolus = false;
                        break;
                    }
                }
            }
        }
        if (dolus) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
