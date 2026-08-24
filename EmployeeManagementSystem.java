import java.util.Scanner;

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static final int MAX_EMPLOYEES = 100;
    static int employeeCount = 0;
    static int[] employeeId = new int[MAX_EMPLOYEES];
    static String[] employeeName = new String[MAX_EMPLOYEES];
    static String[] employeeDepartment = new String[MAX_EMPLOYEES];
    static double[] employeeSalary = new double[MAX_EMPLOYEES];
    static void addEmployee() {
        if (employeeCount >= MAX_EMPLOYEES) {
            System.out.println("Employee limit reached!");
            return;
        }
        System.out.print("Enter Employee ID: ");
        employeeId[employeeCount] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        employeeName[employeeCount] = sc.nextLine();

        System.out.print("Enter Department: ");
        employeeDepartment[employeeCount] = sc.nextLine();

        System.out.print("Enter Salary: ");
        employeeSalary[employeeCount] = sc.nextDouble();

        employeeCount++;

        System.out.println("Employee added successfully!");
    }
    static void viewEmployees() {

        if (employeeCount == 0) {
            System.out.println("No employees found!");
            return;
        }
        System.out.println("\n========== Employee List ==========");

        for (int i = 0; i < employeeCount; i++) {
            System.out.println("Employee ID   : " + employeeId[i]);
            System.out.println("Name          : " + employeeName[i]);
            System.out.println("Department    : " + employeeDepartment[i]);
            System.out.println("Salary        : " + employeeSalary[i]);
            System.out.println("-----------------------------------");
        }
    }
    static void searchEmployee() {

        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < employeeCount; i++) {

            if (employeeId[i] == id) {
                System.out.println("\nEmployee Found!");
                System.out.println("Employee ID : " + employeeId[i]);
                System.out.println("Name        : " + employeeName[i]);
                System.out.println("Department  : " + employeeDepartment[i]);
                System.out.println("Salary      : " + employeeSalary[i]);
                return;
            }
        }
        System.out.println("Employee not found!");
    }
    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employeeCount; i++) {

            if (employeeId[i] == id) {
                System.out.print("Enter New Name: ");
                employeeName[i] = sc.nextLine();
                System.out.print("Enter New Department: ");
                employeeDepartment[i] = sc.nextLine();
                System.out.print("Enter New Salary: ");
                employeeSalary[i] = sc.nextDouble();
                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < employeeCount; i++) {
            if (employeeId[i] == id) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employeeId[j] = employeeId[j + 1];
                    employeeName[j] = employeeName[j + 1];
                    employeeDepartment[j] = employeeDepartment[j + 1];
                    employeeSalary[j] = employeeSalary[j + 1];
                }
                employeeCount--;
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}