package adamobrien.javashopimageeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Driver extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("javaShop.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("JavaShop 1.1");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://illustoon.com/photo/4996.png"));
        stage.show();




    }


    public static void main(String[] args) {
        launch();
    }
}