package Cafe;

import Employee.Employee;

import java.util.ArrayList;

public class EmployeeRecord implements Record {
    private String type;
    private ArrayList<Employee> employeeRecord;

    public EmployeeRecord() {
        this.type = "Employee";

        ArrayList<Employee> oldRentals = new ArrayList<Employee>();
        this.employeeRecord = oldRentals;

    }

    public ArrayList<Employee> getEmployeeRecord() {
        return employeeRecord;
    }


    public void add() {}
    public void update() {}
    public void get() {}

}
