package Cafe;

import Customer.Customer;
import Employee.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Cafe {

    private SalesRecord salesRecord;
    private InventoryRecord inventoryRecord;
    private EmployeeRecord employeeRecord;
    private CustomerRecord customerRecord;

    private ArrayList<String> beverageMenu;
    private ArrayList<String> pastryMenu;
    private ArrayList<String> toppingsMenu;

    private InventoryRecord restock;


    public Cafe(HashMap<String, String> filenames) {
        this.customerRecord = createCustomerFromInput(filenames.get("Customers"));
        this.salesRecord = new SalesRecord();
        this.inventoryRecord = createInventoryFromInput(filenames.get("Inventory"));
        this.employeeRecord = setEmployeesFromInput(filenames.get("Employees"));

        ArrayList<String> beverageMenu = new ArrayList<>();
        this.beverageMenu = beverageMenu;
        ArrayList<String> pastryMenu = new ArrayList<>();
        this.pastryMenu = pastryMenu;
        ArrayList<String> toppingsMenu = new ArrayList<>();
        this.toppingsMenu = toppingsMenu;

        setBevMenu(filenames.get("Beverage"));
        setPastryMenu(filenames.get("Food"));
        setToppingsMenu(filenames.get("Toppings"));
    }

    /**
     * Take inputted txt file and generate the beverage menu for
     * the specific cafe
     */
    void setBevMenu(String file) {
        File filename = new File(file);
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.beverageMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Take inputted txt file and generate the toppings menu for
     * the specific cafe
     */
    void setToppingsMenu(String file) {
        File filename = new File(file);
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.toppingsMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Take inputted txt file and generate the Pastry menu for
     * the specific cafe
     */
    void setPastryMenu(String file) {
        File filename = new File(file);
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                this.pastryMenu.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Take inputted txt file and generate the Employees for
     * the specific cafe
     */
    EmployeeRecord setEmployeesFromInput(String file) {
        EmployeeRecord employeeRecord = new EmployeeRecord();
//        System.out.println(this.inputEmployees);
        File filename = new File(file);

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

    /**
     * Take inputted txt file and record what a full
     * inventory would be in the specific cafe.
     */
    InventoryRecord createInventoryFromInput(String file){
        InventoryRecord inventory = new InventoryRecord(this);
        File filename = new File(file);
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename.getAbsolutePath()))) {

            String line;

            while ((line = inputFile.readLine()) != null) {
                String[] splited = line.split(":");
                inventory.add(splited[0], Integer.parseInt(splited[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.restock = inventory;

        return inventory;
    }

    /**
     * Take inputted txt file and generate a record of prior Loyal
     * Customers for the specific cafe chain
     */
    CustomerRecord createCustomerFromInput(String file){
        CustomerRecord customers = new CustomerRecord();
        File filename = new File(file);
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

    /**
     * When a product runs out of stock, refills the inventory.
     * Performed by the Manager (observer)
     */
    public void restockCafe() {
        setInventoryRecord(restock);
    }

    /* #################### GETTERS AND SETTERS #################### */

    public CustomerRecord getCustomerRecord() { return customerRecord; }

    public ArrayList<String> getBeverageMenu() {return this.beverageMenu;}

    public ArrayList<String> getPastryMenu() {return this.pastryMenu;}

    public void setInventoryRecord(InventoryRecord inventoryRecord) {
        this.inventoryRecord = inventoryRecord;
    }

    public ArrayList<String> getToppingsMenu() {return this.toppingsMenu;}

    public EmployeeRecord getEmployeeRecord() { return employeeRecord; }

    public SalesRecord getSalesRecord() { return salesRecord; }

    public InventoryRecord getInventoryRecord() { return inventoryRecord; }

}
