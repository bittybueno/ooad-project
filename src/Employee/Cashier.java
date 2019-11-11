package Employee;

import Cafe.*;
import Customer.Customer;
import Product.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Cashier extends Employee{
    public Cashier(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,17, employeeID, cafe);
    }

    /**
     * Cashier takes order. Invokes the order (COMMAND) with orderUp(order).
     * Cashier calculates the price of the order. Cashier updates records
     * by running transaction
     */
    public void takeOrder(Order order) {
        Barista barista = order.getBarista();
        Chef chef = order.getChef();
        SalesRecord salesRecord = getCafe().getSalesRecord();
        double priceBeforeRewards;
        double price;

        // set and invoke commands on receivers
        barista.orderUp(order);
        chef.orderUp(order);

        // calculate price of order
        priceBeforeRewards = calculatePrice(order).get("priceBefore");
        price = calculatePrice(order).get("priceAfter");

        // add transaction to sales record
        Reciept reciept = new Reciept(order.getCustomer(), order, price, priceBeforeRewards - price);
        salesRecord.add(reciept);

        // display receipt
        reciept.prettyPrint();
    }

    /**
     * Calculate the cost of the order. Handles rewards if applicable.
     */
    public HashMap<String, Double> calculatePrice(Order order) {
        HashMap<String, Double> ret = new HashMap<String, Double>();
        double price = order.getPrice();

        ret.put("priceBefore", price);

        double priceBeforeRewards = price;
        if (isRewardsCustomer(order)) {
            price = applyRewards(price);
        } else
        {
            if (askToSignUp()) {
                addNewLoyal(order.getCustomer());
                price = applyRewards(price);
            }
        }
        ret.put("priceAfter", price);
        return ret;
    }


    boolean isRewardsCustomer(Order order) {
        return order.getCustomer().isLoyal();
    }


    /**
     * TODO
     */
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

    /**
     * TODO
     */
    double applyRewards(double price) {
        return price - 1.50;
    }
}
