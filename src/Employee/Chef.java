package Employee;
import Cafe.*;
import Product.*;

public class Chef extends Employee implements KitchenEmployee {
    // slot for command
    private Order order;
    SimplePastryFactory pastryFactory = new SimplePastryFactory();
    PastryStore pastryStore = new PastryStore(pastryFactory);

    public Chef(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,35, employeeID, cafe);
    }

    // Template
    public void announce(String type){
        cook(type);
        serve(type);
    }
    public void cook(String type) { System.out.println("\n... Cooking "+ type + "...");}
    public void serve(String type) { System.out.println("... Finished "+ type + "...\n");}

    public void orderUp(Order order) {
        InventoryRecord inventoryRecord = order.getCafe().getInventoryRecord();

        if (!order.getKitchenOrder().isEmpty()) {
//            // loop through food order, create beverage, set associated costs
            for (int i = 0; i < order.getKitchenOrder().size(); i++) {
                // create pastry
                String kitchenOrder = order.getKitchenOrder().get(i);
                Pastry pastry = pastryStore.createPastry(kitchenOrder);
                order.addProducts(pastry);
                // announce pastry is being prepared
                announce(kitchenOrder);

                // update inventory
                inventoryRecord.update(order.getKitchenOrder().get(i), order.getKitchenOrder().size());

                // add cost of making the pastry
                order.addPrice(pastry.cost());
            }
        }
    }
}
