package Employee;
import Cafe.*;

public class Chef extends Employee implements KitchenEmployee {
    public Chef(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    public void serve(){

    }

    public void prepareOrder(String type){
        cook();
        finished();
    }
    public void cook() { System.out.println("... Cooking...");}
    public void finished() { System.out.println("... Finished...");}
}
