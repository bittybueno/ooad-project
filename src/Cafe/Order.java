package Cafe;
import Customer.Customer;
import Product.*;
import Employee.*;
import java.util.ArrayList;

public class Order {

    private Customer customer;
    private String kitchenOrder;
    private String beverageOrder;
    private Barista barista;
    private Chef chef;
    private ArrayList<String> toppings;


    public Barista getBarista() { return barista; }

    public Chef getChef() { return chef; }

    public Customer getCustomer() {
        return customer;
    }

    public String getKitchenOrder() {
        return kitchenOrder;
    }

    public String getBeverageOrder() {
        return beverageOrder;
    }

    public ArrayList<String> getToppings() { return toppings; }


    public Order(Customer customer, String beverageOrder, String kitchenOrder, ArrayList<String> toppings, Barista barista, Chef chef) {
        this.customer = customer;
        this.kitchenOrder = kitchenOrder;
        this.beverageOrder = beverageOrder;
        this.barista = barista;
        this.chef = chef;
        this.toppings = toppings;
    }
}
