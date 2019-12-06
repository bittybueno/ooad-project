package MyUnitTest;
import Cafe.SalesRecord;
import Customer.Customer;
import org.junit.Test;
import Employee.*;
import Cafe.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MyUnitTest {
    @Test
    public void testTakeOrderBeverage() {
        HashMap<String, String> filenames = new HashMap<String, String>();
        filenames.put("Employees", "simulation/simulationEmployees.txt");
        filenames.put("Inventory", "simulation/simulationInventory.txt");
        filenames.put("Customers", "simulation/simulationCustomers.txt");
        filenames.put("Beverage", "simulation/simulationBevMenu.txt");
        filenames.put("Food", "simulation/simulationPastryMenu.txt");
        filenames.put("Toppings", "simulation/simulationToppingsMenu.txt");
        Cafe cafe = new Cafe(filenames );


        Barista barista = new Barista("Don", "Jeremy", 1, cafe);
        Chef chef = new Chef("Eugene", "Crabs", 4, cafe);
        Cashier cashier = new Cashier("Cathy", "Bishop",2,cafe);
        Customer customer = new Customer("Eric");
        ArrayList<String> bev = new ArrayList<String>();
        ArrayList<String> food = new ArrayList<String>();
        ArrayList<String> toppings = new ArrayList<String>();

        bev.add("Coffee");

        Order order = new Order(customer,cafe, bev, food, toppings, barista, chef);

        cashier.takeOrder(order);

        try {
            assertEquals(1.99, order.getPrice(), 0.1);}
        catch (AssertionError e) {
            System.out.println("Test 1 - Failed");
            throw e;
        }
        System.out.println("Test 1 - Passed");
    }

    @Test
    public void testTakeOrderTwoBeverages() {
        HashMap<String, String> filenames = new HashMap<String, String>();
        filenames.put("Employees", "simulation/simulationEmployees.txt");
        filenames.put("Inventory", "simulation/simulationInventory.txt");
        filenames.put("Customers", "simulation/simulationCustomers.txt");
        filenames.put("Beverage", "simulation/simulationBevMenu.txt");
        filenames.put("Food", "simulation/simulationPastryMenu.txt");
        filenames.put("Toppings", "simulation/simulationToppingsMenu.txt");
        Cafe cafe = new Cafe(filenames );

        Barista barista = new Barista("Don", "Jeremy", 1, cafe);
        Chef chef = new Chef("Eugene", "Crabs", 4, cafe);
        Cashier cashier = new Cashier("Cathy", "Bishop",2,cafe);
        Customer customer = new Customer("Eric");
        ArrayList<String> bev = new ArrayList<String>();
        ArrayList<String> food = new ArrayList<String>();
        ArrayList<String> toppings = new ArrayList<String>();

        bev.add("Coffee");
        bev.add("Espresso");

        Order order = new Order(customer,cafe, bev, food, toppings, barista, chef);

        cashier.takeOrder(order);

        try {
            assertEquals(4.99, order.getPrice(), 0.1);}
        catch (AssertionError e) {
            System.out.println("Test 2 - Failed");
            throw e;
        }
        System.out.println("Test 2 - Passed");
    }

    @Test
    public void testTakeOrderFood() {
        HashMap<String, String> filenames = new HashMap<String, String>();
        filenames.put("Employees", "simulation/simulationEmployees.txt");
        filenames.put("Inventory", "simulation/simulationInventory.txt");
        filenames.put("Customers", "simulation/simulationCustomers.txt");
        filenames.put("Beverage", "simulation/simulationBevMenu.txt");
        filenames.put("Food", "simulation/simulationPastryMenu.txt");
        filenames.put("Toppings", "simulation/simulationToppingsMenu.txt");
        Cafe cafe = new Cafe(filenames );

        Barista barista = new Barista("Don", "Jeremy", 1, cafe);
        Chef chef = new Chef("Eugene", "Crabs", 4, cafe);
        Cashier cashier = new Cashier("Cathy", "Bishop",2,cafe);
        Customer customer = new Customer("Eric");
        ArrayList<String> bev = new ArrayList<String>();
        ArrayList<String> food = new ArrayList<String>();
        ArrayList<String> toppings = new ArrayList<String>();

        food.add("Muffin");
        Order order = new Order(customer,cafe, bev, food, toppings, barista, chef);

        cashier.takeOrder(order);
        try {
            assertEquals(4.00, order.getPrice(), 0.1);}
        catch (AssertionError e) {
            System.out.println("Test 3 - Failed");
            throw e;
        }
        System.out.println("Test 3 - Passed");
    }

    @Test
    public void testInventory() {
        HashMap<String, String> filenames = new HashMap<String, String>();
        filenames.put("Employees", "simulation/simulationEmployees.txt");
        filenames.put("Inventory", "simulation/simulationInventory.txt");
        filenames.put("Customers", "simulation/simulationCustomers.txt");
        filenames.put("Beverage", "simulation/simulationBevMenu.txt");
        filenames.put("Food", "simulation/simulationPastryMenu.txt");
        filenames.put("Toppings", "simulation/simulationToppingsMenu.txt");
        Cafe cafe = new Cafe(filenames );

        Barista barista = new Barista("Don", "Jeremy", 1, cafe);
        Chef chef = new Chef("Eugene", "Crabs", 4, cafe);
        Cashier cashier = new Cashier("Cathy", "Bishop",2,cafe);
        Customer customer = new Customer("Eric");
        ArrayList<String> bev = new ArrayList<String>();
        ArrayList<String> food = new ArrayList<String>();
        ArrayList<String> toppings = new ArrayList<String>();

        food.add("Muffin");
        Order order = new Order(customer,cafe, bev, food, toppings, barista, chef);

        cashier.takeOrder(order);

        try {
            Map<String, Integer> inventory = cafe.getInventoryRecord().getInventory();
            assertEquals(99, inventory.get("Muffin"), 1);}
        catch (AssertionError e) {
            System.out.println("Test 4 - Failed");
            throw e;
        }
        System.out.println("Test 4 - Passed");
    }
}
