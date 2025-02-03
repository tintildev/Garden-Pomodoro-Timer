package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.model.SQLiteConnectModel;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import at.mklestil.gardenpomodorotimer.view.StartWindow;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    private final Stage stage;
    private Scene mainScene;
    private AppModel model;
    private SQLiteConnectModel sqLiteConnectModel;
    private int appWidth = 280;
    private int appHeight = 420;
    private Scene startScene;
    private Scene choseScene;
    private StartWindowController startController;
    private ChosePlantController chosePlantController;

    public MainController(Stage stage, AppModel model) {
        this.model = model;
        this.stage = stage;
        sqLiteConnectModel = new SQLiteConnectModel();
        createSessionsDB();
    }
    public void initializeScenes(){
        //Start View
        StartWindow view = new StartWindow();
        startController = new StartWindowController(view, this);
        startScene = new Scene(view.getRoot(), appWidth, appHeight);

        //ChosePlant
        ChosePlant chosePlantView = new ChosePlant();
        chosePlantController = new ChosePlantController(chosePlantView, this);
        choseScene = new Scene(chosePlantView.getRoot(), appWidth, appHeight);
    }

    public void startApp(){
        switchTo("start");
    }

    public void switchTo(String name) {
        //show scene
        if(name.equals("start")){
            stage.setScene(startScene);
            startController.updateView();
        }
        if(name.equals("chose")){
            stage.setScene(choseScene);
        }else {
            System.out.println("Error: Scene " + name +" not found");
        }

    }

    public AppModel getModel() {
        return model;
    }

    public void startDB(){
        //Todo:: weiter mit Datenbank
        //Initial DB
        SQLiteConnectModel sqlModel = new SQLiteConnectModel();
        sqlModel.connect();
        sqlModel.createTable();

        //Set Data
        sqlModel.insertImagePath("/images/start/start.png");
    }

    public void createSessionsDB(){
        //Initial DB
        sqLiteConnectModel.connect();
        sqLiteConnectModel.createTablePomodoroSessions();
    }

    public void saveSession(int time, String plant){
        sqLiteConnectModel.saveSession(time, plant);
        //Test save, log data
        sqLiteConnectModel.loadPomodoroSessions();
    }
}

