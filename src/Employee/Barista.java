package Employee;
import Product.*;
import Cafe.*;

public class Barista extends Employee implements KitchenEmployee{
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);

    private Order order;

    public Barista(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,20, employeeID, cafe);
    }

    public void orderUp(Order order){
        this.order = order;
        order.execute();
    }

    public void announce(String type){
        brew(type);
        serve(type);
    }

    public void brew(String type) { System.out.println("\n...Brewing " + type + "...");}
    public void serve(String type) { System.out.println("...Finished "+ type + "...\n");}


}
