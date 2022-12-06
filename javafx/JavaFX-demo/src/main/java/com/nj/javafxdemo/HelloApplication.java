package com.nj.javafxdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public HelloApplication() {
        String name = Thread.currentThread().getName();
        System.out.println("HelloApplication constructor: " + name);
    }

    @Override
    public void init() {
        String name = Thread.currentThread().getName();
        System.out.println("HelloApplication init(): " + name);

    }

    @Override
    public void start(Stage stage) throws IOException {
        String name = Thread.currentThread().getName();
        System.out.println("HelloApplication start(): " + name);

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Text msg = new Text("Hello JavaFx");
        // Create a button with "Exit"
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.getChildren().addAll(msg, exitBtn);
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 300, 50);
        stage.setTitle("Hello JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("HelloApplication stop(): " + name);

    }

    public static void main(String[] args) {
        launch();
    }
}