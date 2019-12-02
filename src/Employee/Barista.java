package Employee;
import Product.*;
import Cafe.*;

import java.util.ArrayList;

public class Barista extends Employee implements KitchenEmployee{
    // slot for command
    private Order order;
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);


    public Barista(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,20, employeeID, cafe);
    }


    // Template
    public void announce(String type){
        brew(type);
        serve(type);
    }

    public void brew(String type) { System.out.println("\n...Brewing " + type + "...");}
    public void serve(String type) { System.out.println("...Finished "+ type + "...\n");}

    public Beverage addToppings(String toppings, Beverage beverage) {
        Beverage modifiedBeverage = null;
        if (toppings.equals("Whip Cream")) {
            modifiedBeverage = new WhipCream(beverage);
        }
        if (toppings.equals("Extra Shot")) {
            modifiedBeverage = new ExtraShot(beverage);
        }
        return modifiedBeverage;
    }
    public void orderUp(Order order) {
        InventoryRecord inventoryRecord = order.getCafe().getInventoryRecord();

        if (!order.getBeverageOrder().isEmpty()) {
            // loop through beverage order, create beverage, set associated costs
            for (int i = 0; i < order.getBeverageOrder().size(); i++) {
                String beverageOrder = order.getBeverageOrder().get(i);

                // create beverage
                Beverage beverage = beverageStore.createBeverage(order.getBeverageOrder().get(i));
                if (i < order.getToppings().size()) {
                    beverage = addToppings(order.getToppings().get(i), beverage);
                }
                order.addProducts(beverage);

                // announce beverage is being prepared
                announce(beverageOrder);

                // update inventory
                inventoryRecord.update(order.getBeverageOrder().get(i), order.getBeverageOrder().size());

                // add cost of making the beverage
                order.addPrice(beverage.cost());
            }
        }
    }

}
