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
        el.show();

        el.setSalary(3000.0);
        el.show();
        el.setSalary(3000.0);
        el.show();
        el.setSalary(6000.0);
        el.show();
    }

    public static void main(String[] args) {
        launch();
    }

}