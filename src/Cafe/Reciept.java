package Cafe;

import Customer.Customer;

public class Reciept {
    private Customer customer;
    private Order order;
    private double cost;
    private double savings;

    public Reciept(Customer customer, Order order, double cost, double savings) {
        this.customer = customer;
        this.order = order;
        this.cost = cost;
        this.savings = savings;
    }

    public void prettyPrint() {
        System.out.println("\n********* Reciept *********");
        System.out.println("Customer Name: " + customer.getName());
        order.prettyPrint();
        if (customer.isLoyal()) {System.out.println("Loyal Member Savings: " + savings);}
        System.out.println("Cost: " + cost);
        System.out.println("***************************");


    }
}
