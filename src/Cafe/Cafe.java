package Cafe;

import Employee.Employee;

import java.security.PublicKey;

public class Cafe {

    private SalesRecord salesRecord;
    private InventoryRecord inventoryRecord;
    private EmployeeRecord employeeRecord;
    private CustomerRecord customerRecord;


    public Cafe(SalesRecord salesRecord, InventoryRecord inventoryRecord, CustomerRecord customerRecord) {
        this.customerRecord = customerRecord;
        this.salesRecord = salesRecord;
        this.inventoryRecord = inventoryRecord;
//        this.employeeRecord = employeeRecord;
    }

    public EmployeeRecord getEmployeeRecord() {
        return employeeRecord;
    }

    public void setEmployeeRecord(EmployeeRecord employeeRecord) {
        this.employeeRecord = employeeRecord;
    }

    public SalesRecord getSalesRecord() {
        return salesRecord;
    }

    public InventoryRecord getInventoryRecord() {
        return inventoryRecord;
    }
}
