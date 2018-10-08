package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.beans.EventHandler;

public class Vue implements Observateur {

    Modele modele;

    GridPane panneau = new GridPane();
    Label label = new Label("Chronomètre : ");
    Label chrono = new Label("0");

    Button start = new Button("start");
    Button stop = new Button("stop");
    Button reset = new Button("reset");

    Button startStop = new Button("Start");

    Button ralentir = new Button("Ralentir");

    Button accelerer = new Button("Accelerer");


    //

    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        modele.val++;
        setChrono(modele.val);
    }));


    public Vue(Modele modele) {

        this.modele = modele;

        modele.ajoute(this);

        panneau.add(label, 0, 0);
        panneau.add(chrono, 1, 0);
       // panneau.add(start, 0, 1);
       // panneau.add(stop, 1, 1);
        panneau.add(startStop, 0, 1);
        panneau.add(reset, 1, 1);
        panneau.add(ralentir, 0, 2);
        panneau.add(accelerer, 1, 2);
    }

    void startStop(String etat){
        startStop.setText(etat);
    }

    void setChrono(int val){
        chrono.setText(val + "");
    }

    @Override
    public void actualise(double duration) {
        timer.setRate(duration);
    }

}
