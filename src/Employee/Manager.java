package Employee;
import Cafe.*;

//OBSERVER DESIGN PATTERN

public class Manager extends Employee implements Observer {

    public Manager(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    public void orderInventory() {
        System.out.println(getName() + " is filling the inventory!\n\n");
        getCafe().restockCafe();
    }
}
