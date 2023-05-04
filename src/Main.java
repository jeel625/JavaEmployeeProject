import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("1. Add an employee");
            System.out.println("2. Delete an Employee");
            System.out.println("3. Get Employee By Id");
            System.out.println("4. Get All Employee");
            System.out.println("5. Quit");
            System.out.println("=======================:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter Employee department: ");
                    String department = scanner.next();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter Street Number");
                    int streetNumber=scanner.nextInt();
                    System.out.println("Enter Street Name :");
                    String streetName=scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Province");
                    String province=scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Country :");
                    String country=scanner.next();
                    Address address=new Address(streetNumber,streetName,province,country);
                    Employee emp= new Employee(name,department,salary,address);
                    emp.addEmployee(emp);
                    break;
                case 2:
                    Employee removeEmp=new Employee();
                    removeEmp.getAllEmployee();
                    System.out.println("Enter Employee ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    removeEmp.removeEmployee(id);
                    break;
                case 3:
                    Employee getempbyId=new Employee();
                    getempbyId.getAllEmployee();
                    System.out.println("Enyter Employee Id : ");
                    int empId=scanner.nextInt();
                    getempbyId.getEmpById(empId);
                    System.out.println();
                    break;
                case 4:
                    Employee getEmp=new Employee();
                    getEmp.getAllEmployee();
                    break;
                case 5:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 5);
    }
}