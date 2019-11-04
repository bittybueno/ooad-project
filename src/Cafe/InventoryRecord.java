package Cafe;

import Employee.Employee;
import Product.Product;

import java.util.ArrayList;

public class InventoryRecord implements Record{
    private String type;
    private ArrayList<Product> inventoryRecord;

    public InventoryRecord() {
        this.type = "Inventory";

        ArrayList<Product> inventoryRecord = new ArrayList<Product>();
        this.inventoryRecord = inventoryRecord;

    }

    public ArrayList<Product> getInventoryRecordRecord() {
        return inventoryRecord;
    }


    public void add() {}
    public void update() {}
    public void get() {}
}
