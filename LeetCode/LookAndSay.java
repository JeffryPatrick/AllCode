package LeetCode;

public class LookAndSay {
    /*
     * input = 5
     * 1
     * 11
     * 21
     * 1211
     * 111221
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(1);
        String s = "1";
        int i = 1;
        while (i < n) {
            String new_s = "";
            int count = 1;
            char a = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    System.out.print(count + "" + a);
                    new_s += "" + count + "" + a;
                    a = s.charAt(j);
                    count = 1;
                } else {
                    count += 1;
                }
            }
            System.out.println(count + "" + a);
            new_s += "" + count + "" + a;
            s = new_s;
            i++;
        }
    }
}
