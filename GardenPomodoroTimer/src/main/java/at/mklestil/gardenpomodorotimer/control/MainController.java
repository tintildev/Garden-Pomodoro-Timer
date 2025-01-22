package at.mklestil.gardenpomodorotimer.control;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    private final Stage stage;
    private Scene mainScene;
    private final Map<String, Scene> scenes = new HashMap<>();
    private String chose = "";
    private int timeChose = 25;
    private String tagChose = "learn";

    public MainController(Stage stage) {
        this.stage = stage;
    }

    public void addScene(String name, Scene scene) {
        //add scenes to hashmap
        scenes.put(name, scene);
    }

    public void switchTo(String name) {
        //show scene
        mainScene = scenes.get(name);
        if(mainScene!= null){
            stage.setScene(scenes.get(name));
        }else {
            System.out.println("Error: Scene " + name +" not found");
        }
    }

    public Scene getMainScene(){
        return mainScene;
    }

    public String getChose() {
        return chose;
    }

    public void setChose(String chose) {
        this.chose = chose;
    }

    public int getTimeChose() {
        return timeChose;
    }

    public void setTimeChose(int timeChose) {
        this.timeChose = timeChose;
    }

    public String getTagChose() {
        return tagChose;
    }

    public void setTagChose(String tagChose) {
        this.tagChose = tagChose;
    }
}

