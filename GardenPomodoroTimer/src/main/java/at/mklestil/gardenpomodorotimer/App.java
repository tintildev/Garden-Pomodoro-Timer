package at.mklestil.gardenpomodorotimer;

import at.mklestil.gardenpomodorotimer.control.ChosePlantController;
import at.mklestil.gardenpomodorotimer.control.StartWindowController;
import at.mklestil.gardenpomodorotimer.control.MainController;
import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import at.mklestil.gardenpomodorotimer.view.StartWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AppModel model = new AppModel();

        //Add Main Controller to controll data and scenes
        MainController mainController = new MainController(stage, model);
        mainController.initializeScenes();
        mainController.startApp();

        //set Icon, title
        setMyIcon(stage);
        stage.setTitle("Pomodoro Timer");
        stage.show();

    }

    public void setMyIcon(Stage stage){
        //Set Icon and check
        InputStream iconStream = getClass().getResourceAsStream("/images/Icon.png");
        if(iconStream != null){
            Image icon = new Image(iconStream);
            if (!icon.isError()) {
                stage.getIcons().add(icon);
            } else {
                System.out.println("Error loading icon.");
            }
        } else {
            System.out.println("Icon file not found.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}