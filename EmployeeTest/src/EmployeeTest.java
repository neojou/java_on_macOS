package com.nj.binding;

import com.nj.binding.Employee;
import java.beans.PropertyChangeEvent;

public class EmployeeTest {
    public static void main(String[] args) {
        final Employee el = new Employee("Bob", 2000.0);

        computeTax(el.getSalary());
        el.addPropertyChangeListener(
                EmployeeTest::handlePropertyChange);

        el.setSalary(3000.0);
        el.setSalary(3000.0);
        el.setSalary(6000.0);
    }

    public static void handlePropertyChange(PropertyChangeEvent e) {
        if ("salary".equals(e.getPropertyName())) {
            System.out.print("Salary has changed. ");
            System.out.print("Old:" + e.getOldValue());
            System.out.println(", New:" + e.getNewValue());
            computeTax((Double)e.getNewValue());
        }
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0 / 100;
        double tax = salary * TAX_PERCENT;
        System.out.println("Salary:" + salary + ", Tax: " + tax);
    }

}
