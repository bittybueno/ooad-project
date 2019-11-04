package Cafe;

import Customer.Customer;

import java.util.ArrayList;

public class SalesRecord implements Record {
    private String type;
    private ArrayList<Reciept> salesRecord;

    public SalesRecord() {
        this.type = "Sales";

        ArrayList<Reciept> salesRecord = new ArrayList<Reciept>();
        this.salesRecord = salesRecord;

    }

    public ArrayList<Reciept> getCustomerRecord() {
        return salesRecord;
    }


    public void add() {}
    public void update() {}
    public void get() {}
}
