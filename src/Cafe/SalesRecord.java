package Cafe;

import java.util.ArrayList;

public class SalesRecord {
    private String type;
    private ArrayList<Reciept> sales;

    public SalesRecord() {
        this.type = "Sales";

        ArrayList<Reciept> sales = new ArrayList<Reciept>();
        this.sales = sales;

    }

    public void add(Reciept r) { this.sales.add(r);}

}
