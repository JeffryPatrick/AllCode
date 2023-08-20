package LeetCode.Strings;

import java.util.Scanner;

/**
 * ExpandTheString
 */

/*
 * Question 1
 * 
 * Input -> a1b2c3d4
 * Output -> abbcccdddd
 * 
 * Question 2
 * Input -> a1b20c300d4000
 * Output -> print the characters for the given numbers
 */
public class ExpandTheString {

    public static void main(String[] args) {
        // String str = "a1b2c3d4"; // Question 1
        // for (int i = 0; i < str.length(); i++) {
        // if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        // for (int j = 0; j < str.charAt(i) - 48; j++) {
        // System.out.print(str.charAt(i - 1));
        // }
        // }
        // }
        System.out.println();

        String ques2 = "a11b12"; // Question 2
        char temp = ' ';
        int num = 0;
        int j = 0;
        for (int i = 0; i < ques2.length(); i++) {
            if (ques2.charAt(i) >= '0' && ques2.charAt(i) <= '9') {
                temp = ques2.charAt(i - 1);
                for (j = i; j < ques2.length(); j++) {
                    if (ques2.charAt(j) >= '0' && ques2.charAt(j) <= '9') {
                        num = (num * 10) + ques2.charAt(j) - 48;
                    } else {
                        break;
                    }
                }

                for (int k = 0; k < num; k++) {
                    System.out.print(temp);
                }
            }
            i = j;
            num = 0;
        }
    }
}