import java.util.*;

class Student {
    private String studentName;
    private String identityNumber;
    private String dateOfBirth;

    Student(String studentName, String identityNumber, String dateOfBirth) {
        this.studentName = studentName;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return "Name : " + studentName + "Identity Number : " + identityNumber + "Date of Birth : " + dateOfBirth;
    }
}

public class UserDefinedClassInArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        try (Scanner s = new Scanner(System.in)) {
            String studentName, identityNumber, dateOfBirth;
            System.out.println("Enter Student Name : ");
            studentName = s.nextLine();
            System.out.println("Enter the Identity Number : ");
            identityNumber = s.nextLine();
            System.out.println("Enter the Date Of Birth : ");
            dateOfBirth = s.nextLine();
            students.add(new Student(studentName, identityNumber, dateOfBirth));
            for (Student student : students) {
                System.out.println(student + "\n");
            }
        } catch (NullPointerException e) {
            System.out.println("Enter all the details");
        }
    }
}
