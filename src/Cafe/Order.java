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
    private Barista barista;
    private Chef chef;
    private Cafe cafe;
    private ArrayList<String> toppings;
    private double price;

    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);

    SimplePastryFactory pastryFactory = new SimplePastryFactory();
    PastryStore pastryStore = new PastryStore(pastryFactory);

    public Order(Customer customer, Cafe cafe, ArrayList<String> beverageOrder, ArrayList<String> kitchenOrder, ArrayList<String> toppings, Barista barista, Chef chef) {
        this.customer = customer;
        this.kitchenOrder = kitchenOrder;
        this.beverageOrder = beverageOrder;
        this.barista = barista;
        this.chef = chef;
        this.toppings = toppings;
        this.cafe = cafe;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void execute(String type) {
        double price = 0.0;
        Barista barista = this.getBarista();
        Chef chef = this.getChef();
        InventoryRecord inventoryRecord = this.cafe.getInventoryRecord();

        if (!this.getBeverageOrder().isEmpty() && type.equals("Beverage")) {
            // loop through beverage order, create beverage, set associated costs
            for (int i = 0; i < this.getBeverageOrder().size(); i++) {
                // create beverage
                Beverage beverage = beverageStore.createBeverage(this.getBeverageOrder().get(i));
                if (!this.toppings.isEmpty()) {
                    beverage = addToppings(this.toppings, beverage);
                }

                // announce beverage is being prepared
                barista.announce(this.getBeverageOrder().get(i));

                // update inventory
                inventoryRecord.update(this.getBeverageOrder().get(i), this.getBeverageOrder().size());

                // add cost of making the beverage
                price += beverage.cost();
            }
        }

        if (!this.getKitchenOrder().isEmpty() && type.equals("Kitchen")) {
            // loop through food order, create beverage, set associated costs
            for (int i = 0; i < this.getKitchenOrder().size(); i++) {
                // create pastry
                String kitchenOrder = this.getKitchenOrder().get(i);
                Pastry pastry = pastryStore.createPastry(kitchenOrder);

                // announce pastry is being prepared
                chef.announce(kitchenOrder);

                // update inventory
                inventoryRecord.update(this.getKitchenOrder().get(i), this.getKitchenOrder().size());

                // add cost of making the pastry
                price += pastry.cost();
            }
        }

        // set total cost of making the order
        this.price += price;
    }

    /**
     * Decorator
     */
    public Beverage addToppings(ArrayList<String> toppings, Beverage beverage) {
        Beverage modifiedBeverage = null;
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).equals("Whip Cream")) {
                modifiedBeverage = new WhipCream(beverage);
            }
            if (toppings.get(i).equals("Extra Shot")) {
                modifiedBeverage = new ExtraShot(beverage);
            }
        }
        return modifiedBeverage;
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
