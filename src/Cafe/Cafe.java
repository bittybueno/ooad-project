package Cafe;

import Customer.Customer;
import Employee.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Cafe {

    private SalesRecord salesRecord;
    private InventoryRecord inventoryRecord;
    private EmployeeRecord employeeRecord;
    private CustomerRecord customerRecord;

    private ArrayList<String> beverageMenu;
    private ArrayList<String> pastryMenu;
    private ArrayList<String> toppingsMenu;


    public Cafe() {
        this.customerRecord = createCustomerFromInput();
        this.salesRecord = new SalesRecord();
        this.inventoryRecord = createInventoryFromInput();

        ArrayList<String> beverageMenu = new ArrayList<>();
        this.beverageMenu = beverageMenu;
        ArrayList<String> pastryMenu = new ArrayList<>();
        this.pastryMenu = pastryMenu;
        ArrayList<String> toppingsMenu = new ArrayList<>();
        this.toppingsMenu = toppingsMenu;

        createEmployees();
        setBevMenu();
        setPastryMenu();
        setToppingsMenu();
        createInventoryFromInput();
    }

    void setBevMenu() {
        File filename = new File("simulationBevMenu.txt");
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.beverageMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setToppingsMenu() {
        File filename = new File("simulationToppingsMenu.txt");
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.toppingsMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setPastryMenu() {
        File filename = new File("simulationPastryMenu.txt");
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.pastryMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createEmployees(){
        EmployeeRecord employeeRecord = new EmployeeRecord();
        this.employeeRecord = setEmployeesFromInput();

    }

    EmployeeRecord setEmployeesFromInput() {
        EmployeeRecord employeeRecord = new EmployeeRecord();
//        System.out.println(this.inputEmployees);
        File filename = new File("simulationEmployees.txt");

        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                String[] splited = line.split("\\s+");
                if (splited[0].equals("Barista")) {
                    employeeRecord.add(new Barista(splited[1], splited[2], Integer.parseInt(splited[3]), this));
                }
                if (splited[0].equals("Cashier")) {
                    employeeRecord.add(new Cashier(splited[1], splited[2], Integer.parseInt(splited[3]), this));
                }
                if (splited[0].equals("Chef")) {
                    employeeRecord.add(new Chef(splited[1], splited[2], Integer.parseInt(splited[3]), this));
                }
                if (splited[0].equals("Manager")) {
                    employeeRecord.add(new Manager(splited[1], splited[2], Integer.parseInt(splited[3]), this));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeeRecord;
    }

    InventoryRecord createInventoryFromInput(){
        InventoryRecord inventory = new InventoryRecord(this);
        File filename = new File("simulationInventory.txt");
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                String[] splited = line.split(":");
                inventory.add(splited[0], Integer.parseInt(splited[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    CustomerRecord createCustomerFromInput(){
        CustomerRecord customers = new CustomerRecord();
        File filename = new File("simulationCustomers.txt");
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                customers.add(new Customer(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public CustomerRecord getCustomerRecord() { return customerRecord; }

    public ArrayList<String> getBeverageMenu() {return this.beverageMenu;}

    public ArrayList<String> getPastryMenu() {return this.pastryMenu;}

    public ArrayList<String> getToppingsMenu() {return this.toppingsMenu;}

    public EmployeeRecord getEmployeeRecord() { return employeeRecord; }

    public SalesRecord getSalesRecord() { return salesRecord; }

    public InventoryRecord getInventoryRecord() { return inventoryRecord; }

}
