package Employee;

public class Manager extends Employee {

    private static Manager manager;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Manager(String firstName, String lastName, int employeeID) {
        super(firstName, lastName,35, employeeID);
    }

    public static Manager getInstance()
    {
        if (manager==null) {
            manager = new Manager("Jeffery", "Diaz", 1);
        }
        return manager;
    }


    void approvePayroll() {}
    void approve() {}
    void decline() {}

}
