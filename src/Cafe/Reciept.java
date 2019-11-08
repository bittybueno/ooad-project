package Cafe;

import Customer.Customer;

public class Reciept {
    private Customer customer;
    private Order order;
    private double cost;

    public Reciept(Customer customer, Order order, double cost) {
        this.customer = customer;
        this.order = order;
        this.cost = cost;
    }
}
