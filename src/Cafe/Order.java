package Cafe;
import Product.*;
import Employee.*;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private int numberOfItems;
    private ArrayList<Pastry> kitchenOrder;
    private ArrayList<Beverage> beverageOrder;


    public Order(int numberOfItems,String customerName, ArrayList<Beverage> beverageOrder, ArrayList<Pastry> kitchenOrder) {
        this.customerName = customerName;
        this.numberOfItems = numberOfItems;
        this.kitchenOrder = kitchenOrder;
        this.beverageOrder = beverageOrder;
    }
}
