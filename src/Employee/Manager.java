package Employee;
import Cafe.*;

public class Manager extends Employee {

    private static Manager manager;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Manager(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    public static Manager getInstance(Cafe cafe)
    {
        if (manager==null) {
            manager = new Manager("Jeffery", "Diaz", 1, cafe);
        }
        return manager;
    }


    void approvePayroll() {}
    void approve() {}
    void decline() {}

}
