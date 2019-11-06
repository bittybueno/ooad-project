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

    public void update() {}
    public void get() {}
}
