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

    public void prettyPrint() {
        System.out.println("\n________Cafe Sales Record________");
        for (int i = 0; i < sales.size(); i++) {
            Reciept reciept = sales.get(i);
            System.out.println("\nCustomer Name: " + reciept.getCustomer().getName());
            System.out.printf("Cost: $%.2f \n", reciept.getCost());
        }
        System.out.println("\n______________________________\n");
    }
}
