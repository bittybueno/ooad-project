package Employee;

public class Barista extends Employee implements KitchenEmployee{

    public Barista(String firstName, String lastName, int employeeID) {
        super(firstName, lastName,20, employeeID);
    }

    public void serve(){

    }

    public void prepareOrder(){

    }

}
