import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Address
{
    ArrayList<Employee> emp;
    Connection conn;
    ResultSet result=null;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept=dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary=salary;
    }


    public void setAddress(Address address) {
        this.address=address;
    }

    private String dept;
    private double salary;
    private Address address;

    public Employee(int streetNumber, String streetName, String province, String country, int id, String name, String dept, double salary, Address address) {
        super(streetNumber, streetName, province, country);
        this.name=name;
        this.dept=dept;
        this.salary=salary;
        this.address=address;
    }
    public Employee()
    {

    }

    public Employee(String name, String dept, double salary, Address address) {
        this.name=name;
        this.dept=dept;
        this.salary=salary;
        this.address=address;
    }
    public void addEmployee(Employee emp) throws SQLException
    {
        try
        {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            String insertSql="INSERT INTO employees (name, department, salary,address) VALUES ( ?, ?, ?,?)";
            PreparedStatement insertStmt=conn.prepareStatement(insertSql);
            insertStmt.setString(1, emp.getName());
            insertStmt.setString(2, emp.getDept());
            insertStmt.setDouble(3, emp.getSalary());
            insertStmt.setString(4, emp.getAddress());

            int queryExecuted=insertStmt.executeUpdate();
            if (queryExecuted > 0) {
                System.out.println("New User Added Successfully!");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public  void removeEmployee(int id)
    {

        String selectSql = "SELECT id FROM employees WHERE id = ?";
        String deleteSql = "DELETE FROM employees WHERE id = ?";
        try
        {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

            selectStmt.setInt(1, id);
            ResultSet resultSet = selectStmt.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Employee Not Found!");
                return;
            }

            // Delete user
            deleteStmt.setInt(1, id);

            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee Removed Successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updatingEmployee(int id)
    {
        String selectSql = "SELECT id FROM employees WHERE id = ?";
        String updateSql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
        try
        {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql);

            selectStmt.setInt(1, id);
            ResultSet resultSet = selectStmt.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Employee Not Found!");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Name: ");
            String name = scanner.next();
            System.out.print("Enter Department: ");
            String department = scanner.next();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            // Update user
            updateStmt.setInt(1, id);
            updateStmt.setString(2, name);
            updateStmt.setString(3, department);
            updateStmt.setDouble(4, salary);

            int queryUpdated = updateStmt.executeUpdate();
            if (queryUpdated > 0) {
                System.out.println("Employee's Details Updated Successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public  void getAllEmployee()
    {
        String selectSql = "SELECT * FROM employees";
        try
        {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(selectSql);

            System.out.println("ID\tName\tDepartment\tSalary\tAddress");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");
                String address=resultSet.getString("address");
                System.out.println(id + "\t" + name + "\t" + department + "\t" + salary + "\t" + address);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getEmpById(int id)
    {
        String selectSql = "SELECT * FROM employees WHERE id = ?";

        try
        {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
             PreparedStatement stmt = conn.prepareStatement(selectSql);

            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Employee not Found!");
                return;
            }
            // Print user record
            System.out.println("user record:");
            System.out.println("ID\tName\tDepartment\tEmail");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            String email = resultSet.getString("email");
            System.out.println(id + "\t" + name + "\t" + department + "\t" + email);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
