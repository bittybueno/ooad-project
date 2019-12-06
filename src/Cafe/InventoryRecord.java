package Cafe;

import Employee.Manager;
import java.util.HashMap;
import java.util.Map;

// OBSERVER DESIGN PATTERN

public class InventoryRecord implements Subject {
    private String type;
    private Map<String, Integer> inventory;
    private Manager observer;
    private Cafe cafe;

    public InventoryRecord(Cafe cafe) {
        this.cafe = cafe;
        this.type = "Inventory";

        Map<String, Integer> inventory = new HashMap<String, Integer>();
        this.inventory = inventory;
    }

    /**
     * Observer Design Pattern. When Inventory runs out of a Product,
     * notify Manager (Observer) to perform a restock.
     */
    public void notifyObservers() { observer.orderInventory();}

    public void add(String product, int value) {
        this.inventory.put(product, value);
    }

    /**
     * After a transaction occurs, update the inventory
     * for each product that was sold. If a product runs, notify Manager (Observer).
     */
    public void update(String type, int quantity) {
        Map<String, Integer> inventory = cafe.getInventoryRecord().inventory;
        int newValue = inventory.get(type) - quantity;
        inventory.put(type, newValue);
        if (inventory.get(type) <= 0) {
            System.out.println("\n\nCafe is out of " + type);
            // notify manager
            notifyObservers();
        }
    }

    /* #################### GETTERS AND SETTERS #################### */

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setObserver(Manager manager) {
        this.observer = manager;
    }

    /* #################### PRINTING #################### */

    public void prettyPrint() {
        System.out.println("\n________Cafe Inventory________");
        for ( String key : inventory.keySet() ) {
            System.out.printf( "\n%s: %d", key, inventory.get(key) );
        }
        System.out.println("\n______________________________\n");
    }
}
