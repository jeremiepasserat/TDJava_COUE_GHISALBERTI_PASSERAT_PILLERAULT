package sample;

import java.util.ArrayList;

public class ModeleSujet implements Sujet, Modele {
    Modele modele;

    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
    ArrayList<ObservateurBouton> observateursBouton = new ArrayList<ObservateurBouton>();


    public void ajoute(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void ajouteBouton(ObservateurBouton observateurBouton) {
        observateursBouton.add(observateurBouton);
    }

    public ModeleSujet(Modele modele){
        this.modele = modele;
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise(modele.getDuration());
    }

    public void notifieBouton(boolean etatBouton){
        for (ObservateurBouton observateurBouton:observateursBouton)
            observateurBouton.actualise(etatBouton);
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

    @Override
    public void setIsStart() {
        modele.setIsStart();
        notifieBouton(modele.getIsStart());
    }

    @Override
    public boolean getIsStart() {
        return false;
    }
}
