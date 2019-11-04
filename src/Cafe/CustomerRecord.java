package Cafe;

import Customer.Customer;
import Employee.Employee;

import java.util.ArrayList;

public class CustomerRecord implements Record {
    private String type;
    private ArrayList<Customer> customerRecord;

    public CustomerRecord() {
        this.type = "Customer";

        ArrayList<Customer> customerRecord = new ArrayList<Customer>();
        this.customerRecord = customerRecord;

    }

    public ArrayList<Customer> getCustomerRecord() {
        return customerRecord;
    }


    public void add() {}
    public void update() {}
    public void get() {}
}
