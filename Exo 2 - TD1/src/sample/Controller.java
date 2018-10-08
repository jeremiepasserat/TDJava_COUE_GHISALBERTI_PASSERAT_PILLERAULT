package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;

public class Controller{


    Vue vue;

    Modele modele;



    public Controller (Vue vue, Modele modele){

            this.vue = vue;
            this.modele = modele;

            vue.timer.setOnFinished(event -> {
                modele.val ++;
                vue.setChrono(modele.val);
            });

            /*vue.start.setOnAction(event -> {
                vue.timer.setCycleCount(Animation.INDEFINITE);
                vue.timer.play();
            });

            vue.stop.setOnAction(event -> vue.timer.stop());*/

            vue.reset.setOnAction(event -> {
                vue.timer.stop();
                modele.setVal(0);
                vue.setChrono(modele.val);
                vue.startStop("Start");

            });

            vue.startStop.setOnAction(event -> {
                if (vue.startStop.getText() == "Start"){
                    vue.timer.setCycleCount(Animation.INDEFINITE);
                    modele.setDuration(1);
                    vue.timer.play();
                    vue.startStop("Stop");
                }
                else{
                    vue.timer.stop();
                    vue.startStop("Start");
                }

            });

            vue.ralentir.setOnAction(event -> {

                modele.setDuration(0.25);

            });

        vue.accelerer.setOnAction(event -> {

            modele.setDuration(5);
        });

    }

}
