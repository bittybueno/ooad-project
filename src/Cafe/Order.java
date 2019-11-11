package Cafe;
import Customer.Customer;
import Product.*;
import Employee.*;
import java.util.ArrayList;

public class Order implements Command{

    private Customer customer;
    private ArrayList<String> kitchenOrder;
    private ArrayList<String> beverageOrder;
    private Barista barista;
    private Chef chef;
    private Cafe cafe;
    private ArrayList<String> toppings;

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

    public double execute() {
        double price = 0.0;
        Barista barista = this.getBarista();
        Chef chef = this.getChef();

        if (this.getBeverageOrder().size() > 0) {
            for (int i = 0; i < this.getBeverageOrder().size(); i++) {
                // BEVERAGE
                Beverage beverage = beverageStore.createBeverage(this.getBeverageOrder().get(i));
                beverage = addToppings(this.getToppings(), beverage);

                barista.announce(this.getBeverageOrder().get(i));
                this.cafe.getInventoryRecord().update(this.getBeverageOrder().get(i), this.getBeverageOrder().size());

                price += beverage.cost();
            }
        }

        for (int i = 0; i < this.getKitchenOrder().size(); i++) {
            // FOOD
            String kitchenOrder = this.getKitchenOrder().get(i);
            Pastry pastry = pastryStore.createPastry(kitchenOrder);

            chef.announce(kitchenOrder);
            this.cafe.getInventoryRecord().update(this.getKitchenOrder().get(i), this.getKitchenOrder().size());

            price += pastry.cost();
        }
        return price;
    }

    public Beverage addToppings(ArrayList<String> toppings, Beverage beverage) {
        Beverage modifiedBeverage = null;
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i) == "Whip Cream") {
                modifiedBeverage = new WhipCream(beverage);
            }
        }
        return modifiedBeverage;
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

    public ArrayList<String> getToppings() { return toppings; }

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
