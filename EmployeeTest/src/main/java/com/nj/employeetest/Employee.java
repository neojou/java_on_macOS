package com.nj.employeetest;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;

public class Employee {

    private String name;
    DoubleProperty salary;
    final static double TAX_PERCENT = 20.0 / 100;
    NumberBinding tax;

    public Employee() {
        this.name = "John Doe";
        this.salary = new SimpleDoubleProperty(1000.0);
        this.salary.addListener(Employee::changed);
        tax = this.salary.multiply(TAX_PERCENT);
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = new SimpleDoubleProperty(salary);
        this.salary.addListener(Employee::changed);
        tax = this.salary.multiply(TAX_PERCENT);
    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue, Number newValue) {
            System.out.print("Salary has changed. ");
            System.out.print("Old:" + oldValue);
            System.out.println(", New:" + newValue);
    }

    public void show() {
        System.out.println("Salary:" + salary.getValue() + ", Tax: " + tax.getValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary.getValue();
    }

    public void setSalary(double newSalary) {
        salary.set(newSalary);
    }

}
