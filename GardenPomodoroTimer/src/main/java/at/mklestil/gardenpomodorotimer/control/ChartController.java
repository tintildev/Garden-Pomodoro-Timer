package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.PomodoroSession;
import at.mklestil.gardenpomodorotimer.view.ChartView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ChartController {
    private MainController mainController;
    private ChartView view;
    private final ObservableList<PomodoroSession> sessionData = FXCollections.observableArrayList();

    public ChartController(MainController mainController, ChartView view){
        this.view = view;
        this.mainController = mainController;
        this.view.getBackBtn().setOnAction(event -> {
            mainController.switchTo("start");
        });

        setDataToTable();
    }

    private void setDataToTable() {
        sessionData.setAll(mainController.loadSessionsFromDB());
        view.showData(sessionData);
    }

    public void updateView(){
        sessionData.setAll(mainController.loadSessionsFromDB());
    }

}
