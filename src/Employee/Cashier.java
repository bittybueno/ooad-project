package Employee;

import Cafe.*;
import Customer.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Cashier extends Employee{
    public Cashier(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,17, employeeID, cafe);
    }

    /**
     * Cashier takes order. Invokes the order (COMMAND) with execute().
     * Cashier calculates the price of the order. Cashier updates records
     * by running transaction
     */
    public void takeOrder(Order order) {
        SalesRecord salesRecord = getCafe().getSalesRecord();

        order.execute("Beverage");
        order.execute("Kitchen");

        // calculate price of order
        double priceBeforeRewards = calculatePrice(order).get("priceBefore");
        double price = calculatePrice(order).get("priceAfter");

        // add transaction to sales record
        Reciept reciept = new Reciept(order.getCustomer(), order, price, priceBeforeRewards - price);
        salesRecord.add(reciept);

        // display receipt
        reciept.prettyPrint();
    }

    /**
     * Calculate the cost of the order. Handles rewards if applicable.
     * Returns the price before applying  savings and after.
     */
    public HashMap<String, Double> calculatePrice(Order order) {
        HashMap<String, Double> prices = new HashMap<String, Double>();
        Customer customer = order.getCustomer();
        double price = order.getPrice();
        prices.put("priceBefore", price);

        if (isRewardsCustomer(order)) {
            price = applyRewards(price, customer);
        } else
        {
            if (askToSignUp()) {
                System.out.println("New Loyal Member!");
                addNewLoyal(order);
                price = applyRewards(price, customer);
            }
        }
        prices.put("priceAfter", price);
        return prices;
    }

    boolean isRewardsCustomer(Order order) {
        ArrayList<Customer> loyalCustomers = order.getCafe().getCustomerRecord().customers;
        Customer customer = order.getCustomer();

        if (loyalCustomers.contains(customer)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Asks customer if they would like to sign up for a loyalty membership. For simulation,
     * randomly decides.
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

    /**
     * Adds a new Customer to the Loyalty Members list for that Cafe.
     */
    void addNewLoyal(Order order) {
        order.getCafe().getCustomerRecord().add(order.getCustomer());
    }

    /**
     * If a loyal customer accumulates at least 50 points, they will
     * save $5.00 off of their purchase.
     */
    double applyRewards(double price, Customer customer) {
        customer.setLoyaltyPoints(price);

        if (customer.getLoyaltyPoints() > 50) {
            return price - 5.00;
        }

        return price;
    }
}
