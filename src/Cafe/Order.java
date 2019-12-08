package Cafe;
import Customer.Customer;
import Product.*;
import Employee.*;
import java.util.ArrayList;

// COMMAND DESIGN PATTERN

public class Order implements Command{

    private Customer customer;
    private ArrayList<String> kitchenOrder;
    private ArrayList<String> beverageOrder;
    private ArrayList<Product> products;
    private Barista barista;
    private Chef chef;
    private Cafe cafe;
    private ArrayList<String> toppings;
    private double price;

    /**
     * Order acts as the Command Object in the Command Design Pattern.
     * Allows orders to be encapsulated as objects - objects contain all information about the order
     * being placed.
     */
    public Order(Customer customer, Cafe cafe, ArrayList<String> beverageOrder, ArrayList<String> kitchenOrder, ArrayList<String> toppings, Barista barista, Chef chef) {
        this.customer = customer;
        this.kitchenOrder = kitchenOrder;
        this.beverageOrder = beverageOrder;
        this.barista = barista;
        this.chef = chef;
        this.toppings = toppings;
        this.cafe = cafe;

        ArrayList<Product> products = new ArrayList<Product>();
        this.products = products;
    }

    /**
     * Order must implement the execute method as it in a Command object.
     * Execute triggers the reciever.action() method call
     */
    public void execute(String type) {
        Barista barista = this.getBarista();
        Chef chef = this.getChef();

        if (!getBeverageOrder().isEmpty() && type.equals("Beverage")) {
            barista.orderUp(this);
        }

        if (!getKitchenOrder().isEmpty() && type.equals("Kitchen")) {
            chef.orderUp(this);
        }
    }

    public void addProducts(Product product) { this.products.add(product); }

    public void addPrice(double price) { this.price += price; }

    /* #################### GETTERS AND SETTERS #################### */

    public Cafe getCafe() { return cafe; }

    public double getPrice() { return price; }

    public ArrayList<String> getToppings() { return toppings; }

    public Barista getBarista() { return barista; }

    public Chef getChef() { return chef; }

    public Customer getCustomer() { return customer; }

    public ArrayList<String> getKitchenOrder() { return kitchenOrder; }

    public ArrayList<String> getBeverageOrder() { return beverageOrder; }

    /* #################### PRINTING #################### */

    public void prettyPrint() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getDescription() + " ... $" + products.get(i).cost());
        }
    }
}
