package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ModeleSujet modeleSujet = new ModeleSujet(new ModeleConcret());
        Vue vue = new Vue(modeleSujet);
        Controller controller = new Controller(vue, modeleSujet);

        vue.panneau.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Chronomètre");
        primaryStage.setScene(new Scene(vue.panneau, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
