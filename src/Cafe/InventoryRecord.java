package Cafe;

import Employee.Manager;
import Employee.Observer;
import Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventoryRecord implements Subject{
    private String type;
    private Map<String, Integer> inventory;
    private Manager observer;

    public InventoryRecord() {
        this.type = "Inventory";

        Map<String, Integer> inventory = new HashMap<String, Integer>();
        this.inventory = inventory;

    }

    public Map<String, Integer> getInventoryRecordRecord() {
        return inventory;
    }

    public void setObserver(Manager manager) {
        this.observer = manager;
    }
    public void notifyObservers() { observer.orderInventory();}

    public void add(String product, int value) {
        this.inventory.put(product, value);
    }

    public void update(String type, int quantity) {
        int newValue = inventory.get(type) - quantity;
        inventory.put(type, newValue);
        if (inventory.get(type) == 0) {
            System.out.println("\n\nCafe is out of " + type);
            // notify manager
            notifyObservers();
        }
    }

    public void fillInventory() {
        inventory.put("Coffee", 300);
        inventory.put("Espresso", 300);
        inventory.put("Muffin", 100);
        inventory.put("Banana Bread", 100);
    }

    public void prettyPrint() {
        System.out.println("\n________Cafe Inventory________");
        for ( String key : inventory.keySet() ) {
            System.out.printf( "\n%s: %d", key, inventory.get(key) );
        }
        System.out.println("\n______________________________\n");
    }
    public void get() {}
}
