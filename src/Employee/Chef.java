package Employee;
import Cafe.*;

public class Chef extends Employee implements KitchenEmployee {
    public Chef(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    public void serve(){

    }

    public void prepareOrder(String type){
        cook(type);
        finished(type);
    }
    public void cook(String type) { System.out.println("\n... Cooking "+ type + "...");}
    public void finished(String type) { System.out.println("... Finished "+ type + "...\n");}
}
