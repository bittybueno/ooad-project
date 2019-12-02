package Cafe;

import Customer.Customer;
import Product.Product;

import java.util.ArrayList;

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

    public Customer getCustomer() {
        return customer;
    }

    public double getCost() {
        return cost;
    }

    public void prettyPrint() {
        System.out.println("\n********* Reciept *********");
        System.out.println("Customer Name: " + customer.getName());
        order.prettyPrint();
        System.out.printf("Savings: $%.2f \n", savings);
        System.out.printf("Cost: $%.2f \n", cost);
        System.out.println("***************************");


    }
}
