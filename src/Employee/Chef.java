package Employee;

public class Chef extends Employee implements KitchenEmployee {
    public Chef(String firstName, String lastName, int employeeID) {
        super(firstName, lastName,35, employeeID);
    }

    public void serve(){

    }

    public void prepareOrder(){

    }
}
