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

    ContenuVue contenuVue = new ContenuVue();


    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        modele.setVal(modele.getVal()+1);
        setChrono(modele.getVal());
    }));


    public Vue(ModeleSujet modele) {

        this.modele = modele;

        modele.ajoute(this);

        modele.ajouteBouton(this);

    }

    void startStop(String etat){
        contenuVue.startStop.setText(etat);
    }

    void setChrono(int val){
        contenuVue.chrono.setText(val + "");
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
