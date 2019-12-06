package Employee;
import Product.*;
import Cafe.*;

// TEMPLATE DESIGN PATTERN

public class Barista extends Employee implements KitchenEmployee{
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);


    public Barista(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,20, employeeID, cafe);
    }

    // Template
    public void orderUp(Order order) {
        InventoryRecord inventoryRecord = order.getCafe().getInventoryRecord();

        if (!order.getBeverageOrder().isEmpty()) {
            // loop through beverage order, create beverage, set associated costs
            for (int i = 0; i < order.getBeverageOrder().size(); i++) {
                String beverageOrder = order.getBeverageOrder().get(i);

                // announce beverage is starting to be brewed
                brew(beverageOrder);

                // create beverage
                Beverage beverage = beverageStore.createBeverage(order.getBeverageOrder().get(i));

                // add toppings if necessary
                if (i < order.getToppings().size()) {
                    beverage = addToppings(order.getToppings().get(i), beverage);
                }

                // add to finished products
                order.addProducts(beverage);

                // update inventory
                inventoryRecord.update(order.getBeverageOrder().get(i), order.getBeverageOrder().size());

                // add cost of making the beverage
                order.addPrice(beverage.cost());

                // announce beverage is completed & ready to be served
                serve(beverageOrder);
            }
            System.out.println("Barista "+order.getBarista().getName()+": 'Order for " + order.getCustomer().getName() + "!'");
        }
    }

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

    public void brew(String type) { System.out.println("\n...Brewing " + type + "...");}
    public void serve(String type) { System.out.println("...Finished "+ type + "...\n"); }


}
