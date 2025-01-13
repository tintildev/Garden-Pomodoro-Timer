package at.mklestil.gardenpomodorotimer;

import at.mklestil.gardenpomodorotimer.control.MyController;
import at.mklestil.gardenpomodorotimer.control.SceneManger;
import at.mklestil.gardenpomodorotimer.view.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Add SceneManger
        SceneManger sceneManger = new SceneManger(stage);

        //Start View
        MainWindow view = new MainWindow();
        MyController controller = new MyController(view);
        Scene startScene = new Scene(view.getRoot(), 280, 420);
        sceneManger.addScene("start", startScene);



        //start first scene
        sceneManger.switchTo("start");

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