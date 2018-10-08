package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Modele modele = new Modele();
        Vue vue = new Vue(modele);
        Controller controller = new Controller(vue, modele);

        vue.panneau.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(vue.panneau, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
