package elec;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import javax.swing.Timer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller {
    
    //Shows how much energy the player made
    public Label energyMeter;
    
    //Progress bars
    public ProgressBar zeroOneProg;
    public ProgressBar oneOneProg;
    public ProgressBar twoOneProg;
    public ProgressBar threeOneProg;
    public ProgressBar zeroFourProg;
    public ProgressBar oneFourProg;
    public ProgressBar twoFourProg;
    public ProgressBar threeFourProg;
    
    //Buttons to buy
    public Button zeroOneBut;
    public Button oneOneBut;
    public Button twoOneBut;
    public Button threeOneBut;
    public Button zeroFourBut;
    public Button oneFourBut;
    public Button twoFourBut;
    public Button threeFourBut;

    //Labels for the progress bars
    public Label zeroOneLab;
    public Label oneOneLab;
    public Label twoOneLab;
    public Label threeOneLab;
    public Label zeroFourLab;
    public Label oneFourLab;
    public Label twoFourLab;
    public Label threeFourLab;
    
    //Buttons to upgrade
    public Button zeroOneUpg;
    public Button oneOneUpg;
    public Button twoOneUpg;
    public Button threeOneUpg;
    public Button zeroFourUpg;
    public Button oneFourUpg;
    public Button twoFourUpg;
    public Button threeFourUpg;

    //Progress bar progress vars
    private double zeroOneProgNum;

    //Keeps track of amount of energy created
    private long mAH = 0;


    public void energyClick(ActionEvent action) {
        mAH++;
        energyMeter.setText(mAH + " mAH");


    }


    private double zeroOneDelay = 0.001;

    //Timer, executes once a frame
   private  AnimationTimer zeroOneTim = new AnimationTimer(){

        double progDelay;
        double zeroOneProgNum = 0;
        boolean subtractMAH = true;

        public void handle(long now){

            if(subtractMAH){
                updateMAH(-5);
                subtractMAH = false;
            }

            if(progDelay % 5 == 0)
                zeroOneProgNum += zeroOneDelay;

            progDelay++;

            zeroOneProg.setProgress(zeroOneProgNum);

            if(zeroOneProg.getProgress() >= 1.0) {
                zeroOneProg.setProgress(0);

                updateMAH(15);

                progDelay = 0;
                zeroOneProgNum = 0;
                subtractMAH = true;

                zeroOneTim.stop();
            }
        }

    };

    //Costs 5 mAH
    public void zeroOneClick(ActionEvent action){
        if(action.getSource().equals(zeroOneBut)){
            if(mAH >= 5) {

                zeroOneTim.start();
            }


        }
        else if(action.getSource().equals(zeroOneUpg)){

            if(mAH >= 5) {
                zeroOneDelay += 0.001;
                updateMAH(-5);
            }
        }
    }


    public void updateMAH(long val){
        mAH += val;

        energyMeter.setText(mAH + " mAH");


    }
}
