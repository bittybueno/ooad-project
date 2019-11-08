package Employee;
import Product.*;
import Cafe.*;

public class Barista extends Employee implements KitchenEmployee{
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);

    public Barista(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,20, employeeID, cafe);
    }

    public void serve(){

    }

    public void prepareOrder(String type){
        brew();
    }

    public void brew() { System.out.println("... Brewing...");}


}
