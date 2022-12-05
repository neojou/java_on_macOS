package com.nj.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Text msg = new Text("Hello JavaFx");
        VBox root = new VBox();
        root.getChildren().add(msg);
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 300, 50);
        stage.setTitle("Hello JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}