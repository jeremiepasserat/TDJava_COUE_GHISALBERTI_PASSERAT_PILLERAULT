package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class Modele implements Sujet  {

    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public void ajoute(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise(duration);
    }

    int val = 0;

    double duration;

    void setDuration (double duration){
        this.duration = duration;
        notifie();
    }

    void setVal (int val){
        this.val = val;
    }





}
