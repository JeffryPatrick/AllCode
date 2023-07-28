import java.util.HashSet;

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
    }
}
