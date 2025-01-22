package at.mklestil.gardenpomodorotimer;

import at.mklestil.gardenpomodorotimer.control.ChosePlantController;
import at.mklestil.gardenpomodorotimer.control.StartWindowController;
import at.mklestil.gardenpomodorotimer.control.MainController;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import at.mklestil.gardenpomodorotimer.view.StartWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class App extends Application {
    private int appWidth = 280;
    private int appHeight = 420;


    @Override
    public void start(Stage stage) throws IOException {

        //Add Main Controller to controll data and scenes
        MainController mainController = new MainController(stage);

        //Start View
        StartWindow view = new StartWindow();
        StartWindowController controller = new StartWindowController(view, mainController);
        Scene startScene = new Scene(view.getRoot(), appWidth, appHeight);
        mainController.addScene("start", startScene);

        //ChosePlant
        ChosePlant chosePlantView = new ChosePlant();
        ChosePlantController chosePlantController = new ChosePlantController(chosePlantView, mainController);
        Scene choseScene = new Scene(chosePlantView.getRoot(), appWidth, appHeight);
        mainController.addScene("chose", choseScene);

        //start first scene
        mainController.switchTo("start");

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