import LeetCode.*;

public class Main {
    public static void main(String[] args) {
        int[] digit1 = { 1, 2, 3 };
        int[] digit2 = { 1, 2, 9 };
        int[] digit3 = { 9, 9, 9 };
        int[] answer = PlusOne.digitOne(digit1);
        for (int i : answer) {
            System.out.print(i);
        }
        System.out.println();
        answer = PlusOne.digitOne(digit2);
        for (int i : answer) {
            System.out.print(i);
        }
        System.out.println();
        answer = PlusOne.digitOne(digit3);
        for (int i : answer) {
            System.out.print(i);
        }
    }
}
