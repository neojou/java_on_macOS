package com.nj.employeetest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        final Employee el = new Employee("Bob", 2000.0);

        computeTax(el.getSalary());
        el.addPropertyChangeListener(
                HelloApplication::handlePropertyChange);

        el.setSalary(3000.0);
        el.setSalary(3000.0);
        el.setSalary(6000.0);

    }

    public static void main(String[] args) {
        launch();
    }

    public static void handlePropertyChange(PropertyChangeEvent e) {
        if ("salary".equals(e.getPropertyName())) {
            System.out.print("Salary has changed. ");
            System.out.print("Old:" + e.getOldValue());
            System.out.println(", New:" + e.getNewValue());
            computeTax((Double) e.getNewValue());
        }
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0 / 100;
        double tax = salary * TAX_PERCENT;
        System.out.println("Salary:" + salary + ", Tax: " + tax);
    }

}