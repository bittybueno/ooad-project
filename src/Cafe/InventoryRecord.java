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


    public void notifyObservers() {}

    public void add(String product, int value) {
        this.inventory.put(product, value);
    }

    public void update(String type, int quantity) {
//        System.out.println("HERE "+quantity + type);
        int newValue = inventory.get(type) - quantity;
        inventory.put(type, newValue);
        if (inventory.get(type) == 0) {
            // notify manager
            notifyObservers();
        }
    }

    public void prettyPrint() {
        //Map<String,String> map
//        inventory.forEach(e -> System.out.printf("%s: %s", inventory.k));
        System.out.println("\n________Cafe Inventory________");
        for ( String key : inventory.keySet() ) {
            System.out.printf( "\n%s: %d", key, inventory.get(key) );
        }
        System.out.println("\n______________________________\n");
    }
    public void get() {}
}
