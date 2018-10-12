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

            vue.reset.setOnAction(event -> {
                vue.timer.stop();
                modele.setVal(0);
                vue.setChrono(modele.getVal());
                vue.startStop("Start");

            });

            vue.startStop.setOnAction(event -> {
                modele.setIsStart();
            });

            vue.ralentir.setOnAction(event -> {

                modele.setDuration(0.25);

            });

        vue.accelerer.setOnAction(event -> {

            modele.setDuration(5);
        });

    }

}
