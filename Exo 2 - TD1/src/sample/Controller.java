package sample;

import javafx.animation.Animation;

public class Controller{


    Vue vue;

    Modele modele;





    public Controller (Vue vue, Modele modele){

            this.vue = vue;
            this.modele = modele;

            /*vue.start.setOnAction(event -> {
                vue.timer.setCycleCount(Animation.INDEFINITE);
                vue.timer.play();
            });

            vue.stop.setOnAction(event -> vue.timer.stop());*/

            vue.contenuVue.reset.setOnAction(event -> {
                vue.timer.stop();
                modele.setVal(0);
                vue.setChrono(modele.getVal());
                vue.startStop("Start");

            });

            vue.contenuVue.startStop.setOnAction(event -> {
                modele.setIsStart();
            });

            vue.contenuVue.ralentir.setOnAction(event -> {

                modele.setDuration(0.25);

            });

        vue.contenuVue.accelerer.setOnAction(event -> {

            modele.setDuration(5);
        });

    }

}
