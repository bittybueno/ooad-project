package Employee;
import java.util.UUID;
import Cafe.*;

abstract public class Employee {

    private int payRate;
    private String firstName;
    private String lastName;
    private int employeeID;
    private Cafe cafe;

    public Cafe getCafe() {
        return cafe;
    }

    public Employee(String firstName, String lastName, int payRate, int employeeID, Cafe cafe) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.payRate = payRate;
        this.employeeID = employeeID;
        this.cafe = cafe;
    }

    public String getName() {
        return firstName + " " +lastName;
    }

}
