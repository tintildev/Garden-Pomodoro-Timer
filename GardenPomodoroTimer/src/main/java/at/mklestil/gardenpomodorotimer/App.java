package at.mklestil.gardenpomodorotimer;

import at.mklestil.gardenpomodorotimer.control.MyController;
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
        MainWindow view = new MainWindow();
        MyController controller = new MyController(view);
        Scene scene = new Scene(view.getRoot(), 280, 420);

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

        stage.setTitle("Pomodoro Timer");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}