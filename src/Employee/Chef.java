package Employee;
import Cafe.*;
import Product.*;

// TEMPLATE DESIGN PATTERN

public class Chef extends Employee implements KitchenEmployee {
    SimplePastryFactory pastryFactory = new SimplePastryFactory();
    PastryStore pastryStore = new PastryStore(pastryFactory);

    public Chef(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    // Template
    public void orderUp(Order order) {
        InventoryRecord inventoryRecord = order.getCafe().getInventoryRecord();

        if (!order.getKitchenOrder().isEmpty()) {
            // loop through food order, create beverage, set associated costs
            for (int i = 0; i < order.getKitchenOrder().size(); i++) {
                String kitchenOrder = order.getKitchenOrder().get(i);

                // announce beverage is starting to be brewed
                cook(kitchenOrder);

                // create pastry
                Pastry pastry = pastryStore.createPastry(kitchenOrder);

                // add to finished products
                order.addProducts(pastry);

                // update inventory
                inventoryRecord.update(order.getKitchenOrder().get(i), order.getKitchenOrder().size());

                // add cost of making the pastry
                order.addPrice(pastry.cost());

                // announce beverage is completed & ready to be served
                serve(kitchenOrder);
            }
            System.out.println("Chef "+order.getChef().getName()+": Order for " + order.getCustomer().getName() + "!");

        }
    }

    public void cook(String type) { System.out.println("\n... Cooking "+ type + "...");}
    public void serve(String type) { System.out.println("... Finished "+ type + "...\n");}
}
