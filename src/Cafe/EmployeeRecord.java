package Cafe;

import Employee.Employee;

import java.util.ArrayList;

public class EmployeeRecord {
    private String type;
    private ArrayList<Employee> employees;

    public EmployeeRecord() {
        this.type = "Employee";

        ArrayList<Employee> employeeRecord = new ArrayList<Employee>();
        this.employees = employeeRecord;

    }

    public ArrayList<Employee> getEmployeeRecord() {
        return employees;
    }


    public void add(Employee employee) {
        this.employees.add(employee);
    }
    public void update() {}
    public void get() {}

}
