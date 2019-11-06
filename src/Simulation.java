import Cafe.Reciept;
import Employee.*;
import Customer.*;
import Product.*;

import java.util.ArrayList;

public class Simulation {

    ArrayList<Employee> createEmployees(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(Manager.getInstance());

        // BARISTA
        employees.add(new Barista("David", "Baker", 2));

        //CASHIER
        employees.add(new Cashier("Katie", "Andrews", 4));

        //CHEF
        employees.add(new Chef("Bobby", "Day", 7));

        return employees;
    }

    ArrayList<Reciept> createSalesRecord(){
        ArrayList<Reciept> salesRecord = new ArrayList<Reciept>();

        return salesRecord;
    }

    ArrayList<Customer> createCustomerRecord(){
        ArrayList<Customer> customerRecord = new ArrayList<Customer>();
        customerRecord.add(new Customer("David", true));
        customerRecord.add(new Customer("Jozi", true));
        customerRecord.add(new Customer("Terri", true));


        return customerRecord;
    }

    ArrayList<Product> createProducts(){
        SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
        BeverageStore beverageStore = new BeverageStore(beverageFactory);

        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(beverageStore.createBeverage("Coffee"));


        return inventory;
    }





    public static void main(String[] args) {
        Simulation sim = new Simulation();
        ArrayList<Customer> customers = sim.createCustomerRecord();
        ArrayList<Employee> employees = sim.createEmployees();
        ArrayList<Product> inventory = sim.createProducts();
        ArrayList<Reciept> salesRecord = sim.createSalesRecord();

        System.out.println(inventory);
    }
}
