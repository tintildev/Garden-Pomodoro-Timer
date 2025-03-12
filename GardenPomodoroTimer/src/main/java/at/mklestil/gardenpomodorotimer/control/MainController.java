package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.model.SQLiteConnectModel;
import at.mklestil.gardenpomodorotimer.service.LanguageManager;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import at.mklestil.gardenpomodorotimer.view.ErrorHandler;
import at.mklestil.gardenpomodorotimer.view.SettingsView;
import at.mklestil.gardenpomodorotimer.view.StartWindow;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
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
    private Scene settingsScene;
    private StartWindowController startController;
    private ChosePlantController chosePlantController;
    private SettingsController settingsController;

    public MainController(Stage stage, AppModel model) {
        this.model = model;
        this.stage = stage;
        sqLiteConnectModel = new SQLiteConnectModel();

        // Set language before views are loaded
        LanguageManager.getInstance();

        //create Tables
        startDBs();
    }

    /**
     * Initialize the view and controllers.
     */
    public void initializeScenes(){
        //Start View
        StartWindow view = new StartWindow();
        startController = new StartWindowController(view, this);
        startScene = new Scene(view.getRoot(), appWidth, appHeight);
        startScene.getStylesheets().add(getClass().getResource("/styles/startWindowStyle.css").toExternalForm());

        //ChosePlant
        ChosePlant chosePlantView = new ChosePlant();
        chosePlantController = new ChosePlantController(chosePlantView, this);
        choseScene = new Scene(chosePlantView.getRoot(), appWidth, appHeight);
        choseScene.getStylesheets().add(getClass().getResource("/styles/chosePlant.css").toExternalForm());

        // Settings
        SettingsView settingsView = new SettingsView();
        settingsController = new SettingsController(settingsView);
        settingsScene = new Scene(settingsView.getRoot(), appWidth, appHeight);

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
        else if(name.equals("chose")) {
            stage.setScene(choseScene);
        } else if (name.equals("settings")) {
            stage.setScene(settingsScene);

    }else {
            System.out.println("Error: Scene " + name +" not found");
            ErrorHandler.showError("Error: Scene " + name +" not found");
        }

    }

    public AppModel getModel() {
        return model;
    }

    private void startDBs(){
        createSessionsDB();
        createTagDB();

    }

    private void createSessionsDB(){
        //Initial DB
        sqLiteConnectModel.connect();
        sqLiteConnectModel.createTablePomodoroSessions();
    }

    public void saveSession(int time, String plant){
        sqLiteConnectModel.saveSession(time, plant);
        //Test save, log data
        sqLiteConnectModel.loadPomodoroSessions();
    }

    private void createTagDB(){
        //Initial DB
        sqLiteConnectModel.connect();
        sqLiteConnectModel.createTagsTable();
    }

    public List<String> loadTagsFromDB(){
        return sqLiteConnectModel.loadTagsFromDB();
    }

    public void changeLanugage(){
        LanguageManager.getInstance().addLanguageChangeListener(() -> {
            System.out.println("Language has been changed! UI needs to be updated now.");
            initializeScenes(); // reload UI Elements
        });
    }
}



