package Cafe;

import Employee.Employee;

import java.security.PublicKey;

public class Cafe {
    private SalesRecord salesRecord;
    private InventoryRecord inventoryRecord;
    private EmployeeRecord employeeRecord;
    private CustomerRecord customerRecord;


    public Cafe(SalesRecord salesRecord, InventoryRecord inventoryRecord, EmployeeRecord employeeRecord, CustomerRecord customerRecord) {
        this.customerRecord = customerRecord;
        this.salesRecord = salesRecord;
        this.inventoryRecord = inventoryRecord;
        this.employeeRecord = employeeRecord;
    }
}
