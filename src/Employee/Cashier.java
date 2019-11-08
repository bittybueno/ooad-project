package Employee;

import Cafe.*;
import Customer.Customer;
import Product.*;
import java.util.ArrayList;

public class Cashier extends Employee{
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);

    public Cashier(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,17, employeeID, cafe);
    }

    public void takeOrder(Order order) {
        Beverage beverage = beverageStore.createBeverage(order.getBeverageOrder());

        // update inventory
        getCafe().getInventoryRecord().update(order.getBeverageOrder(), 1);

        addToppings(order.getToppings(), beverage);

        double price = beverage.cost();

        if (isRewardsCustomer(order)) {
            price = applyRewards(price);
        } else
        {
            if (askToSignUp()) {
                addNewLoyal(order.getCustomer());
                price = applyRewards(price);
            }
        }

        Reciept reciept = new Reciept(order.getCustomer(), order, price);


        order.getBarista().prepareOrder(order.getBeverageOrder());

        // update sales record
        this.getCafe().getSalesRecord().add(reciept);



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

    boolean isRewardsCustomer(Order order) {
        return order.getCustomer().isLoyal();
    }


    public boolean askToSignUp() {
        if(new java.util.Random().nextInt(8)==0){
            return true;
        }
        else
        {
            return false;
        }
    }

    void addNewLoyal(Customer customer) {
        customer.setLoyal(true);
    }

    double applyRewards(double price) {
        return price - 1.50;
    }

    void orderUp() {

    }

    void finishTransaction() {
        // params: Order: order
        // maybe return a reciept?
    }
}
