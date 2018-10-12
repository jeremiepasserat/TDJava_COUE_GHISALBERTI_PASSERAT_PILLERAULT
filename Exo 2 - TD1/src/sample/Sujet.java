package sample;

public interface Sujet {
    void ajoute (Observateur observateur);
    void ajouteBouton (ObservateurBouton observateurBouton);
    void notifie();
    void notifieBouton(boolean etatBouton);
}
