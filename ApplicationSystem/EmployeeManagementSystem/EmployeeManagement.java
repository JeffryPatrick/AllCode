package ApplicationSystem.EmployeeManagementSystem;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Employee
 */
class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(int id, String name, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee [id = " + id + ", name = " + name + ", age = " + age + ", department = " + department
                + ", salary = " + salary + "]";
    }
}

/**
 * Department
 */
enum Department {
    InformationTechnology, HumanResource, Finance, Marketing
}

/**
 * Company
 */
class Company {
    private String name;
    private int yearsOfWork;
    private double fiscalValue;
    private int noOfEmployees;
    Department department;

    public Company(String name, int yearsOfWork, double fiscalValue, int noOfEmployees, Department department) {
        this.name = name;
        this.yearsOfWork = yearsOfWork;
        this.fiscalValue = fiscalValue;
        this.noOfEmployees = noOfEmployees;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Company[" + "name = " + name + ", Years Of Work = " + yearsOfWork + ", Fiscal Value = " + fiscalValue
                + ", No Of Employees = " + noOfEmployees + ", Department = " + department + "]";
    }
}

/**
 * EmployeeServices
 */
interface EmployeeServices {
    void viewAllEmployees();

    void viewEmployee();

    void addEmployee();

    void deleteEmployee();
}

/**
 * EmployeeServiceImplementation
 */
class EmployeeServiceImplementation implements EmployeeServices {

    HashSet<Employee> employeeDetails = new HashSet<>();

    Employee emp1 = new Employee(101, "Jeffry", 20, "Developer", 30000);
    Employee emp2 = new Employee(102, "Patrick", 21, "Tester", 25000);
    Employee emp3 = new Employee(103, "Jerry", 19, "DevOps Eng", 5000);

    Scanner sc = new Scanner(System.in);
    boolean found = false;
    int id;
    String name;
    int age;
    String department;
    double salary;

    public EmployeeServiceImplementation() {
        employeeDetails.add(emp1);
        employeeDetails.add(emp2);
        employeeDetails.add(emp3);
    }

    @Override
    public void addEmployee() {
        System.out.println("Enter the id : ");
        id = sc.nextInt();
        System.out.println("Enter the name : ");
        name = sc.next();
        System.out.println("Enter age : ");
        age = sc.nextInt();
        System.out.println("Enter Department : ");
        department = sc.next();
        System.out.println("Enter Salary : ");
        salary = sc.nextDouble();

        Employee emp = new Employee(id, name, age, department, salary);
        employeeDetails.add(emp);
        System.out.println(emp);
        System.out.println("Employee added Successfully!");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Enter the id : ");
        id = sc.nextInt();
        boolean found = false;
        Employee empDelete = null;
        for (Employee employee : employeeDetails) {
            if (employee.getId() == id) {
                empDelete = employee;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee is not present");
        } else {
            employeeDetails.remove(empDelete);
            System.out.println("Employee Deleted Successfully");
        }
    }

    @Override
    public void viewAllEmployees() {
        for (Employee employee : employeeDetails) {
            System.out.println(employee);
        }
    }

    @Override
    public void viewEmployee() {
        System.out.println("Enter the id : ");
        id = sc.nextInt();
        for (Employee employee : employeeDetails) {
            if (employee.getId() == id) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee with this id is not present");
        }
    }
}

/**
 * EmployeeManagement
 */
public class EmployeeManagement {

    public static void menu() {
        System.out.println("----------Welcome to Employee Management System---------");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. View All Employee");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            EmployeeServiceImplementation esi = new EmployeeServiceImplementation();
            do {
                menu();
                System.out.println("Enter your Choice : ");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Add Employee");
                        esi.addEmployee();
                        break;
                    case 2:
                        System.out.println("View Employee");
                        esi.viewEmployee();
                        break;
                    case 3:
                        System.out.println("Delete Employee");
                        esi.deleteEmployee();
                        break;
                    case 4:
                        System.out.println("View All Employees");
                        esi.viewAllEmployees();
                        break;
                    case 5:
                        System.out.println("Thanks For using Application!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Enter a valid choice");
                        break;
                }
            } while (true);
        }
    }
}
