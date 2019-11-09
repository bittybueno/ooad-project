package Cafe;
import Customer.Customer;
import Product.*;
import Employee.*;
import java.util.ArrayList;

public class Order {

    private Customer customer;
    private ArrayList<String> kitchenOrder;
    private ArrayList<String> beverageOrder;
    private Barista barista;
    private Chef chef;
    private ArrayList<String> toppings;


    public Barista getBarista() { return barista; }

    public Chef getChef() { return chef; }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<String> getKitchenOrder() {
        return kitchenOrder;
    }

    public ArrayList<String> getBeverageOrder() {
        return beverageOrder;
    }

    public ArrayList<String> getToppings() { return toppings; }


    public Order(Customer customer, ArrayList<String> beverageOrder, ArrayList<String> kitchenOrder, ArrayList<String> toppings, Barista barista, Chef chef) {
        this.customer = customer;
        this.kitchenOrder = kitchenOrder;
        this.beverageOrder = beverageOrder;
        this.barista = barista;
        this.chef = chef;
        this.toppings = toppings;
    }

    public void prettyPrint() {
        System.out.println("\nBeverage Order: ");
        for (int i = 0; i < beverageOrder.size(); i++) {
            System.out.println(beverageOrder.get(i));
        }

        System.out.println("\nKitchen Order: ");
        for (int i = 0; i < kitchenOrder.size(); i++) {
            System.out.println(kitchenOrder.get(i));
        }

        System.out.println("\nAdd Ons: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(toppings.get(i));
        }
    }
}
