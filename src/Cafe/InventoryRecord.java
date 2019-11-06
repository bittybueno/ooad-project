package Cafe;

import Employee.Manager;
import Employee.Observer;
import Product.Product;

import java.util.ArrayList;

public class InventoryRecord implements Record, Subject{
    private String type;
    private ArrayList<Product> inventoryRecord;
    private Manager observer;

    public InventoryRecord() {
        this.type = "Inventory";

        ArrayList<Product> inventoryRecord = new ArrayList<Product>();
        this.inventoryRecord = inventoryRecord;

    }

    public ArrayList<Product> getInventoryRecordRecord() {
        return inventoryRecord;
    }


    public void notifyObservers() {}

    public void add() {}
    public void update() {}
    public void get() {}
}
