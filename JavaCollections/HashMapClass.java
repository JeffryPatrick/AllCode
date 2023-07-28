import java.util.*;

public class HashMapClass {
    public static void main(String[] args) {
        HashMap<Integer, String> employee = new HashMap<Integer, String>();
        employee.put(1000, "ABC");
        employee.put(1001, "BCD");
        employee.put(1002, "CDE");
        employee.put(1003, null);
        employee.put(1004, "EFG");
        employee.put(1005, "FGH");
        System.out.println(employee);
        System.out.println(employee.get(1004));
        System.out.println(employee.putIfAbsent(1003, "GHI"));
        System.out.println(employee.containsValue("FGH"));
        System.out.println(employee.containsKey(1008));
        System.out.println(employee);
    }
}
