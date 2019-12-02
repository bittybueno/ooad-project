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

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

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

    public void addPrice(double price) {
        this.price += price;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void execute(String type) {
        Barista barista = this.getBarista();
        Chef chef = this.getChef();
        InventoryRecord inventoryRecord = this.cafe.getInventoryRecord();

        if (!this.getBeverageOrder().isEmpty() && type.equals("Beverage")) {
            barista.orderUp(this);
        }

        if (!this.getKitchenOrder().isEmpty() && type.equals("Kitchen")) {
            chef.orderUp(this);
        }
    }

    public double getPrice() {
        return price;
    }

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

    public void prettyPrint() {
//        System.out.println("\nBeverage Order: ");
//        for (int i = 0; i < beverageOrder.size(); i++) {
//            System.out.println(beverageOrder.get(i));
//        }
//
//        System.out.println("\nKitchen Order: ");
//        for (int i = 0; i < kitchenOrder.size(); i++) {
//            System.out.println(kitchenOrder.get(i));
//        }
//
//        System.out.println("\nAdd Ons: ");
//        for (int i = 0; i < toppings.size(); i++) {
//            System.out.println(toppings.get(i));
//        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getDescription() + " ... $" +products.get(i).cost());
        }
    }
}
