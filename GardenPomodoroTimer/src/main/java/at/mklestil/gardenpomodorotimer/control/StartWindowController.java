package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.model.SQLiteConnectModel;
import at.mklestil.gardenpomodorotimer.view.StartWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class StartWindowController {
    private StartWindow view;
    private int workTime = 25 * 60; // 25 Minuten
    private int remainingTime = workTime;
    private Timeline timeline;
    private String formatTime;
    private int progress = 0;
    private MainController mainController;
    private AppModel model;



    public StartWindowController(StartWindow view, MainController sManger) {
        this.view = view;
        mainController = sManger;
        model = mainController.getModel();
        initialize();
    }

    public void initialize(){
        formatTime = view.getTimeLabel().getText();
        view.getStartButton().setOnAction(e -> startTimer());
        view.getBreakButton().setOnAction(e -> pauseTimer());
        view.getResetButton().setOnAction(e -> resetTimer());

        view.getPlus().setOnAction(e -> plusTime());
        view.getMinus().setOnAction(e -> minusTime());
        view.getLearnTag().setText(model.getTag());
        view.initialTrees(new ArrayList<String>());

        //Switch Scene
        view.getPlantImageView().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            mainController.switchTo("chose");
        });
    }
    public void updateView(){
        System.out.println("Scene switch to Start, update view!");
        view.getLearnTag().setText(model.getTag());
        setWorkTime(model.getTime() * 60);
        remainingTime = workTime;
        view.getTimeLabel().setText(formatTime(remainingTime));
    }

    private void updateTimer() {
        if (remainingTime > 0) {
            remainingTime--;
            double progressTime = (double) (workTime - remainingTime) / workTime;
            view.getProgress().setProgress(progressTime);
            view.getTimeLabel().setText(formatTime(remainingTime));

            //Change Images
            if (workTime > 0) {  // Fortschritt erhöhen
                progress = (int) (progressTime * 100);

                // calculate image stage with the progress
                int stage = progress / 20;  // 5 images, at all 20%
                //System.out.println("% : " + progress / 20);

                // check stage and image length
                if (stage >= 0 && stage < view.getPlantStages().length) {
                    //set ImageView image stage
                    //Todo:: set DB Data (arraylist ?) imagepaths
                    view.getPlantImageView().setImage(view.getPlantStages()[stage]);
                }
            }
        }
        else if (remainingTime == 0){
            // Finish Timer
            view.getStatus().setText("Great Job!");
        }else {
            // Timer-Ende
            pauseTimer();
        }
    }

    public void startTimer(){
        if (timeline == null || timeline.getStatus() == Timeline.Status.STOPPED) {
            timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            view.getStatus().setText("Do not give up!");
            view.getPlantImageView().setImage(view.getPlantStages()[0]);
        }else {
            //Pause
            timeline.play();
            view.getStatus().setText("Pause ? Do not give up!");
        }
    }

    public void pauseTimer() {
        if (timeline != null) {
            timeline.pause();
            view.getStatus().setText("Wait");
        }
    }

    public void resetTimer() {
        if (timeline != null) {
            timeline.stop();
            view.getStatus().setText("Ready to start!");
        }
        remainingTime = workTime;  // Reset remainingTime to workTime
        view.getTimeLabel().setText(formatTime(remainingTime)); //reset
        view.getProgress().setProgress(0); // reset progress
        view.getPlantImageView().setImage(view.getPlantStages()[0]); //reset image
    }

    public void plusTime() {
        workTime = workTime + 60; // 1 min;
        remainingTime = workTime;
        view.getTimeLabel().setText(formatTime(remainingTime));
    }
    public void minusTime() {
        // no negativ time
        if (workTime > 60) {
            workTime = workTime - 60; // 1 min;
            remainingTime = workTime;
            view.getTimeLabel().setText(formatTime(remainingTime));
        }
    }

    public String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        formatTime = String.format("%02d:%02d", minutes, secs);
        return formatTime;
    }

    public void setWorkTime(int time){
        workTime = time;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
