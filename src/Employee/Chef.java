package Employee;
import Cafe.*;

public class Chef extends Employee implements KitchenEmployee {
    // slot for command
    private Order order;

    public Chef(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    public void orderUp(Order order){
        this.order = order;
        order.execute("Kitchen");
    }

    // Template
    public void announce(String type){
        cook(type);
        serve(type);
    }
    public void cook(String type) { System.out.println("\n... Cooking "+ type + "...");}
    public void serve(String type) { System.out.println("... Finished "+ type + "...\n");}
}
