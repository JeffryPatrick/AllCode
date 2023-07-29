package LeetCode;

/*
 *  [1,2,3] => [1,2,4]
 *  [1,2,9] => [1,3,0]
 *  [9,9,9] => [1,0,0,0]
 */
public class PlusOne {
    public static int[] digitOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
