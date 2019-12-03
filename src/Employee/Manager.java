package Employee;
import Cafe.*;

//OBSERVER DESIGN PATTERN

public class Manager extends Employee implements Observer {

    // private constructor to force use of
    // getInstance() to create Singleton object
    public Manager(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }


    public void orderInventory() {
        System.out.println(this.getName() + " is filling the inventory\n\n");
        fillInventory();
    }

    public void fillInventory() {this.getCafe().getInventoryRecord().fillInventory();}

}
