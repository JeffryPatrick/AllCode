import java.util.HashSet;
import java.util.Set;

public class HashSetClass {
    public static void main(String[] args) {
        HashSet<String> chemicals = new HashSet<String>();
        chemicals.add("Magnesium");
        chemicals.add("Sulphur");
        chemicals.add("Carbon");
        chemicals.add("Nitrogen");
        chemicals.add("Oxygen");
        chemicals.add("Helium");
        chemicals.add("Gold");
        chemicals.add("Titanium");
        System.out.println(chemicals.contains("Oxygen"));
        System.out.println(chemicals);
        System.out.println(chemicals.isEmpty());
        System.out.println(chemicals.hashCode());
        int i = 0;
        for (String s : chemicals) {
            if (i == 2)
                System.out.println(s);
            i++;
        }

        Set<Integer> ans = new HashSet<>();
        ans.add(1);
        ans.add(4);
        ans.add(3);
        ans.add(-2);
        System.out.println(ans);
    }
}
