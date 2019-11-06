import Cafe.*;
import Employee.*;
import Customer.*;
import Product.*;

import java.util.*;

public class Simulation {
    public ArrayList<Customer> newCustomers;
    public CustomerRecord loyalCustomersRecord;
    public int maxLoyal;
    public int min;

    public Simulation() {
        createNewCustomers();
        this.maxLoyal = 6;
        this.min = 0;
    }

    EmployeeRecord createEmployees(){
        EmployeeRecord employeeRecord = new EmployeeRecord();
        employeeRecord.add(Manager.getInstance());

        // BARISTA
        employeeRecord.add(new Barista("David", "Baker", 2));

        //CASHIER
        employeeRecord.add(new Cashier("Katie", "Andrews", 4));

        //CHEF
        employeeRecord.add(new Chef("Bobby", "Day", 7));

        return employeeRecord;
    }

    SalesRecord createSalesRecord(){
        SalesRecord salesRecord = new SalesRecord();
        return salesRecord;
    }

    CustomerRecord createCustomerRecord(){
        CustomerRecord customerRecord = new CustomerRecord();
        customerRecord.add(new Customer("David", true));
        customerRecord.add(new Customer("Jozi", true));
        customerRecord.add(new Customer("Terri", true));
        customerRecord.add(new Customer("Colby", true));
        customerRecord.add(new Customer("Parker", true));
        customerRecord.add(new Customer("Hodge", true));

        this.loyalCustomersRecord = customerRecord;

        return customerRecord;
    }

    InventoryRecord createInventory(){
        InventoryRecord inventory = new InventoryRecord();
//        SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
//        BeverageStore beverageStore = new BeverageStore(beverageFactory);
//
//        ArrayList<Product> inventory = new ArrayList<Product>();
//
//        inventory.add(beverageStore.createBeverage("Coffee"));
//        inventory.add(beverageStore.createBeverage("Coffee"));
//        inventory.add(beverageStore.createBeverage("Coffee"));
//        inventory.add(beverageStore.createBeverage("Coffee"));
//        inventory.add(beverageStore.createBeverage("Coffee"));

        inventory.add("Coffee", 300);
        inventory.add("Muffin", 100);



        return inventory;
    }

    void createNewCustomers() {
        ArrayList<Customer> newCustomers = new ArrayList<Customer>();
        newCustomers.add(new Customer("Eric", false));
        newCustomers.add(new Customer("Rei", false));
        newCustomers.add(new Customer("Connie", false));
        this.newCustomers = newCustomers;
    }

    ArrayList<Customer> customersForTheDay(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
//        ArrayList<Customer> newCustomers = new ArrayList<Customer>();

        int lenOfNew = this.newCustomers.size();
        int customerNumLoyal = randomInt(0, this.maxLoyal); // loyal
        int customerNumNew = randomInt(0, this.newCustomers.size()/3); // loyal

        Collections.shuffle(this.loyalCustomersRecord.customers);
        for (int i = 0; i < customerNumLoyal; i ++) {
            customers.add(this.loyalCustomersRecord.customers.get(i));
        }

        Collections.shuffle(this.newCustomers);
        for (int i = 0; i < customerNumNew; i ++) {
            customers.add(this.newCustomers.get(i));
        }

        return customers;

    }

    Order createOrder(int numberOfItems,String customerName, ArrayList<Beverage> beverageOrder, ArrayList<Pastry> kitchenOrder) {
        Order order = new Order(numberOfItems, customerName, beverageOrder, kitchenOrder);
        return order;
    }

    int randomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }





    public static void main(String[] args) {
        Simulation sim = new Simulation();

        EmployeeRecord employees = sim.createEmployees();
        SalesRecord sales = sim.createSalesRecord();
        CustomerRecord customers = sim.createCustomerRecord();
        InventoryRecord inventory = sim.createInventory();

        Cafe cafe = new Cafe(sales, inventory, employees, customers);

        ArrayList<Customer> customersForDay = sim.customersForTheDay();
        for (int i = 0; i < customersForDay.size(); i++) {
            System.out.println(customersForDay.get(i).getName() + " is Loyal Member: " + customersForDay.get(i).isLoyal());
        }


    }
}
