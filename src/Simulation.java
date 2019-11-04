import Cafe.Reciept;
import Employee.*;
import Customer.*;

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

        return customerRecord;
    }







    public static void main(String[] args) {

    }
}
