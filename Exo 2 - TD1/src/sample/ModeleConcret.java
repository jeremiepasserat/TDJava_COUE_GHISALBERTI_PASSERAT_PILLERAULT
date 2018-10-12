package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class ModeleConcret implements Modele  {



    int val = 0;

    double duration;

    boolean isStart = true;

    public void setDuration (double duration){
        this.duration = duration;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    public void setVal (int val){
        this.val = val;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public void setIsStart() {
        isStart = !(isStart);
    }

    @Override
    public boolean getIsStart() {
        return isStart;
    }


}
