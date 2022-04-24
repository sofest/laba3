package com.example.lab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(loader.load()); //приложение получает интерфейс из fxml
        stage.setTitle("Reactors");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}