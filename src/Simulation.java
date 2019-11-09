import Cafe.*;
import Employee.*;
import Customer.*;
import Product.*;

import java.util.*;

public class Simulation {
    public ArrayList<Customer> newCustomers;
    public CustomerRecord loyalCustomersRecord;
    public Cafe cafe;
    ArrayList<String> beverageMenu;
    ArrayList<String> pastryMenu;
    ArrayList<String> toppingsMenu;
    public int maxLoyal;
    public int min;

    public Simulation() {
        createNewCustomers();
        this.maxLoyal = 6;
        this.min = 0;
    }

    public void setMenu() {
        ArrayList<String> beverageMenu = new ArrayList<>();
        beverageMenu.add("Coffee");

        ArrayList<String> pastryMenuy = new ArrayList<>();
        beverageMenu.add("Muffin");

        ArrayList<String> toppingsMenu = new ArrayList<>();
        beverageMenu.add("Whip Cream");

        this.toppingsMenu = toppingsMenu;
    }

    EmployeeRecord createEmployees(Cafe cafe){
        EmployeeRecord employeeRecord = new EmployeeRecord();
        employeeRecord.add(Manager.getInstance(cafe));

        // BARISTA
        employeeRecord.add(new Barista("David", "Baker", 2, cafe));

        //CASHIER
        employeeRecord.add(new Cashier("Katie", "Andrews", 4, cafe));

        //CHEF
        employeeRecord.add(new Chef("Bobby", "Day", 7, cafe));

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

    HashMap<String, Employee> employeesForTheDay(EmployeeRecord employeesForCafe) {
        ArrayList<Employee> employeeRecord = employeesForCafe.getEmployees();
        HashMap<String, Employee>  employees = new HashMap<String, Employee> ();
        Collections.shuffle(employeeRecord);
        // select a random barista

        int i = 0;
        while (i < employeeRecord.size()) {
            if (employeeRecord.get(i) instanceof Barista) {
                employees.put("Barista",employeeRecord.get(i));
                break;
            }
            i++;
        }

        int j = 0;
        while (j < employeeRecord.size()) {
            if (employeeRecord.get(j) instanceof Cashier) {
                employees.put("Cashier",employeeRecord.get(j));
                break;
            }
            j++;
        }

        int l = 0;
        while (l < employeeRecord.size()) {
            if (employeeRecord.get(l) instanceof Chef) {
                employees.put("Chef",employeeRecord.get(l));
                break;
            }
            l++;
        }

        int m = 0;
        while (m < employeeRecord.size()) {
            if (employeeRecord.get(m) instanceof Manager) {
                employees.put("Manager",employeeRecord.get(m));
                break;
            }
            m++;
        }


        return employees;

    }

    public ArrayList<String> randomBeverageOrder() {
//        return 1 + (int)(Math.random() * ((5 - 1) + 1));

        ArrayList<String> beverage = new ArrayList<String>();
        beverage.add("Coffee");
        return beverage;
    }

    public ArrayList<String> randomToppingsOrder() {
//        int numOfToppings = 1 + (int)(Math.random() * ((3 - 1) + 1));
//        int i = 0;
        ArrayList<String> toppings = new ArrayList<String>();
        toppings.add("Whip Cream");
//        Collections.shuffle(this.toppingsMenu);
//        while (i < numOfToppings) {
//            toppings.add(this.toppingsMenu.get(i));
//            i++;
//        }

        return toppings;
    }

    public ArrayList<String> randomPastryOrder() {

        ArrayList<String> pastry = new ArrayList<String>();
        pastry.add("Muffin");
        return pastry;
    }

    Order order(Customer customer, Cashier cashier, Barista barista, Chef chef) {
        Order order = new Order(customer, randomBeverageOrder(), randomPastryOrder(), randomToppingsOrder(),barista, chef);
        cashier.takeOrder(order);
        return order;
    }

    int randomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }


    public void daySimulation() {
        HashMap<String, Employee> employees = employeesForTheDay(cafe.getEmployeeRecord());
        ArrayList<Customer> customers = customersForTheDay();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getName());
            order(customers.get(i), (Cashier) employees.get("Cashier"), (Barista) employees.get("Barista"), (Chef) employees.get("Chef"));
        }
    }

    public void setCafe(Cafe cafe) {this.cafe = cafe;}

    public void weeklySim(){
        cafe.getInventoryRecord().prettyPrint();
        for (int i = 0; i < 8; i++) {
            System.out.println("\n\n####### Day " + i + "#######");
            daySimulation();
        }
        cafe.getInventoryRecord().prettyPrint();
    }



    public static void main(String[] args) {
        Simulation sim = new Simulation();

        SalesRecord sales = sim.createSalesRecord();
        CustomerRecord customers = sim.createCustomerRecord();
        InventoryRecord inventory = sim.createInventory();

        Cafe cafe = new Cafe(sales, inventory, customers);

        EmployeeRecord employees = sim.createEmployees(cafe);
        cafe.setEmployeeRecord(employees);

        sim.setCafe(cafe);
        sim.setMenu();

//        sim.daySimulation();
        sim.weeklySim();
//        ArrayList<Customer> customersForDay = sim.customersForTheDay();
//        for (int i = 0; i < customersForDay.size(); i++) {
//            System.out.println(customersForDay.get(i).getName() + " is Loyal Member: " + customersForDay.get(i).isLoyal());
//
//        }

        // cashiers take orders
//        ArrayList<Employee> employeesForDay = sim.employeesForTheDay(cafe.getEmployeeRecord());
//        for (int i = 0; i < employeesForDay.size(); i++) {
//            System.out.println(employeesForDay.get(i).getName());
//        }
//        ArrayList<Employee> employeesForDay = sim.employeesForTheDay(cafe.getEmployeeRecord());
//        for (int i = 0; i < employeesForDay.size(); i++) {
//            Employee e = employeesForDay.get(i);
//            System.out.println("###### Employee Information ######");
//            System.out.println("Employee Name: " + e.getName());
//            System.out.println("Employee ID: " + e.getEmployeeID());
//        }


    }
}
