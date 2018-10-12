package sample;

import java.util.ArrayList;

public class ModeleSujet implements Sujet, Modele {
    Modele modele;

    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public void ajoute(Observateur observateur) {
        observateurs.add(observateur);
    }

    public ModeleSujet(Modele modele){
        this.modele = modele;
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise(modele.getDuration());
    }


    @Override
    public void setDuration(double duration) {
        modele.setDuration(duration);
        notifie();
    }

    @Override
    public double getDuration() {
        return modele.getDuration();
    }

    @Override
    public void setVal(int val) {
        modele.setVal(val);
    }

    @Override
    public int getVal() {
        return modele.getVal();
    }
}
