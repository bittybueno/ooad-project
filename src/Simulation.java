import Cafe.*;
import Employee.*;
import Customer.*;

import java.util.*;

public class Simulation {
    public ArrayList<Customer> newCustomers;
    public Cafe cafe;

    public Simulation() {
        // Creates New Customers
        createNewCustomers();
    }

    void createNewCustomers() {
        ArrayList<Customer> newCustomers = new ArrayList<Customer>();
        newCustomers.add(new Customer("Eric"));
        newCustomers.add(new Customer("Rei"));
        newCustomers.add(new Customer("Connie"));
        newCustomers.add(new Customer("Paul"));
        newCustomers.add(new Customer("Tanner"));
        newCustomers.add(new Customer("Josh"));
        this.newCustomers = newCustomers;
    }

    /**
     * Simulation takes a random number of loyal and
     * new customers to visit the shop each day
     */
    ArrayList<Customer> customersForTheDay(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Customer> loyal = cafe.getCustomerRecord().customers;

        // random number of each
        int customerNumLoyal = randomInt(0, loyal.size());
        int customerNumNew = randomInt(0, this.newCustomers.size()/3);

        // randomize
        Collections.shuffle(loyal);
        for (int i = 0; i < customerNumLoyal; i ++) {
            customers.add(loyal.get(i));
        }

        // randomize
        Collections.shuffle(this.newCustomers);
        for (int i = 0; i < customerNumNew; i ++) {
            customers.add(this.newCustomers.get(i));
        }
        return customers;
    }

    /**
     * Simulation takes a random barista, chef,
     * manager, and cashier
     */
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

    /**
     * Simulation generates a random beverage order
     */
    ArrayList<String> randomBeverageOrder() {
        ArrayList<String> beverage = new ArrayList<String>();
        int numOfBevs =  1+ (int)(Math.random() * ((3 - 1) + 1));

        int i = 0;
        while (i < numOfBevs) {
            int index = ((int)(Math.random() * this.cafe.getBeverageMenu().size() + 1)) - 1;
            beverage.add(this.cafe.getBeverageMenu().get(index));
            i++;
        }

        return beverage;
    }

    /**
     * Simulation generates a random Toppings order
     */
    ArrayList<String> randomToppingsOrder() {
        ArrayList<String> toppings = new ArrayList<String>();
        int numOfToppings =   (int)(Math.random() * ((2 - 1) + 1));

        int i = 0;
        while (i < numOfToppings) {
            int index = ((int)(Math.random() * cafe.getToppingsMenu().size() + 1)) - 1;
            toppings.add(cafe.getToppingsMenu().get(index));
            i++;
        }

        return toppings;
    }

    /**
     * Simulation generates a random Pastry order
     */
    ArrayList<String> randomPastryOrder() {

        ArrayList<String> pastry = new ArrayList<String>();
        int numOfPastries =  (int)(Math.random() * ((2 - 1) + 1));

        int i = 0;
        while (i < numOfPastries) {
            int index = ((int)(Math.random() * this.cafe.getPastryMenu().size() + 1)) - 1;
            pastry.add(this.cafe.getPastryMenu().get(index));
            i++;
        }

        return pastry;
    }

    /**
     * Customer in simulation makes a random order based on the
     * menu for the Cafe
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
        printEmployees(employees);
        ArrayList<Customer> customers = customersForTheDay();
        for (int i = 0; i < customers.size(); i++) {
            cafe.getInventoryRecord().setObserver((Manager) employees.get("Manager"));
            order(customers.get(i), (Cashier) employees.get("Cashier"), (Barista) employees.get("Barista"), (Chef) employees.get("Chef"));
        }
    }
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
        cafe.getSalesRecord().prettyPrint();;
    }

    public void setCafe(Cafe cafe) {this.cafe = cafe;}

    /* #################### PRINTING #################### */

    public void printEmployees(HashMap<String, Employee> employees) {
        System.out.println("Manager: " + employees.get("Manager").getName());
        System.out.println("Cashier: " + employees.get("Cashier").getName());
        System.out.println("Barista: " + employees.get("Barista").getName());
        System.out.println("Chef: " + employees.get("Chef").getName());
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



    public static void main(String[] args) {
        Simulation sim = new Simulation();

        HashMap<String, String> filenames = new HashMap<String, String>();
        filenames.put("Employees", "simulationEmployees.txt");
        filenames.put("Inventory", "simulationInventory.txt");
        filenames.put("Customers", "simulationCustomers.txt");
        filenames.put("Beverage", "simulationBevMenu.txt");
        filenames.put("Food", "simulationPastryMenu.txt");
        filenames.put("Toppings", "simulationToppingsMenu.txt");

        Cafe cafe = new Cafe(filenames );
        sim.setCafe(cafe);
        sim.weeklySim();


//        filenames.put("Inventory", "simulationInventory2.txt");
//        filenames.put("Beverage", "simulationBevMenu2.txt");
//
//        Cafe cafe2 = new Cafe(filenames);
//        sim.setCafe(cafe2);
//        sim.weeklySim();
    }
}
