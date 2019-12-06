package Cafe;

import Customer.Customer;
import java.util.ArrayList;

public class CustomerRecord {
    private String type;
    public ArrayList<Customer> customers;

    public CustomerRecord() {
        this.type = "Customer";

        ArrayList<Customer> customerRecord = new ArrayList<Customer>();
        this.customers = customerRecord;

    }

    public void add(Customer c) { this.customers.add(c); }

}
