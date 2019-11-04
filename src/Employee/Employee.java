package Employee;
import java.util.UUID;

abstract public class Employee {

    private int payRate;
    private String firstName;
    private String lastName;
    private int employeeID;

    public Employee(String firstName, String lastName, int payRate, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.payRate = payRate;
        this.employeeID = employeeID;
    }

    public String getName() {
        return firstName + lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getPayRate() {
        return payRate;
    }

    public boolean login(){
        return true;
    }

    public void inputHours(){

    }
}
