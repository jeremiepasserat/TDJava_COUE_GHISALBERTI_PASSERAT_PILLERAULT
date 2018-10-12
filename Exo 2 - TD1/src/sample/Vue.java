package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Vue implements Observateur, ObservateurBouton {

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


    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        modele.setVal(modele.getVal()+1);
        setChrono(modele.getVal());
    }));


    public Vue(ModeleSujet modele) {

        this.modele = modele;

        modele.ajoute(this);

        modele.ajouteBouton(this);

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

    @Override
    public void actualise (boolean etatBouton) {

        if (!etatBouton){
            timer.setCycleCount(Animation.INDEFINITE);
            modele.setDuration(1);
            timer.play();
            startStop("Stop");
        }
        else{
            timer.stop();
            startStop("Start");
        }
    }

}
