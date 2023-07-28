import java.util.ArrayList;

public class ArrayListClass {
    public static void main(String[] args) {
        ArrayList<Character> capitalLetters = new ArrayList<Character>();
        for (int i = 65; i < 91; i++) {
            capitalLetters.add((char) i);
        }
        System.out.println("Size of Capital Letters : " + capitalLetters.size());
        System.out.println("Contents of captital letters : " + capitalLetters);
        System.out.println("Get the 2nd value : " + capitalLetters.isEmpty());
        System.out.println("The 15th index value is removed : " + capitalLetters.remove(15));        
        System.out.println("Contents of captital letters : " + capitalLetters);        
    }
}
