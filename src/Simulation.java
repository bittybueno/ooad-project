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

    ArrayList<String> randomBeverageOrder() {
        ArrayList<String> beverage = new ArrayList<String>();
        int numOfBevs =  1 + (int)(Math.random() * ((3 - 1) + 1));

        int i = 0;
        while (i < numOfBevs) {
            int index = ((int)(Math.random() * this.cafe.getBeverageMenu().size() + 1)) - 1;
            beverage.add(this.cafe.getBeverageMenu().get(index));
            i++;
        }

        return beverage;
    }

    ArrayList<String> randomToppingsOrder() {
        ArrayList<String> toppings = new ArrayList<String>();
        int numOfToppings =  1 + (int)(Math.random() * ((2 - 1) + 1));

        int i = 0;
        while (i < numOfToppings) {
            int index = ((int)(Math.random() * cafe.getToppingsMenu().size() + 1)) - 1;
            toppings.add(cafe.getToppingsMenu().get(index));
            i++;
        }

        return toppings;
    }

    ArrayList<String> randomPastryOrder() {

        ArrayList<String> pastry = new ArrayList<String>();
        int numOfPastries =  1 + (int)(Math.random() * ((2 - 1) + 1));

        int i = 0;
        while (i < numOfPastries) {
            int index = ((int)(Math.random() * this.cafe.getPastryMenu().size() + 1)) - 1;
            pastry.add(this.cafe.getPastryMenu().get(index));
            i++;
        }

        return pastry;
    }

    /**
     * For visualizing the simulation
     */
    public void printCustomerOrder(String customerName, ArrayList<String> bevOrder, ArrayList<String> pastryOrder, ArrayList<String> toppings){
        System.out.printf("\n\n###################################\n ");
        System.out.printf(customerName + " would like ");
        ArrayList<String> orderPrint= new ArrayList<String>();
        orderPrint.addAll(bevOrder);
        orderPrint.addAll(pastryOrder);
        orderPrint.addAll(toppings);
        orderPrint.forEach(value -> System.out.print("- "+value+" -"));

    }

    /**
     * Customer in simulation makes a random order based on the
     * menu for the simulation
     */
    Order order(Customer customer, Cashier cashier, Barista barista, Chef chef) {
        ArrayList<String> bevOrder = randomBeverageOrder();
        ArrayList<String> pastryOrder = randomPastryOrder();
        ArrayList<String> toppings = randomToppingsOrder();

        printCustomerOrder(customer.getName(), bevOrder, pastryOrder,toppings);
        Order order = new Order(customer, this.cafe, bevOrder, pastryOrder,toppings, barista, chef);
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
            cafe.getInventoryRecord().setObserver((Manager) employees.get("Manager"));
            order(customers.get(i), (Cashier) employees.get("Cashier"), (Barista) employees.get("Barista"), (Chef) employees.get("Chef"));
        }
    }

    public void setCafe(Cafe cafe) {this.cafe = cafe;}

    /**
     * Run simulation for a week
     */
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

        // setting up cafe simulation
        CustomerRecord customers = sim.createCustomerRecord();

        Cafe cafe = new Cafe(customers);

        // setting up variables for simulation
        sim.setCafe(cafe);
//
//        // run simulation for a week
        sim.weeklySim();
    }
}
