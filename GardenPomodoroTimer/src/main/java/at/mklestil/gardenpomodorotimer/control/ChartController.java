package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.PomodoroSession;
import at.mklestil.gardenpomodorotimer.view.ChartView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChartController {
    private MainController mainController;
    private ChartView view;

    public ChartController(MainController mainController, ChartView view){
        this.view = view;
        this.mainController = mainController;
        this.view.getBackBtn().setOnAction(event -> {
            mainController.switchTo("start");
        });

        setDataToTable();
    }

    private void setDataToTable() {
        ObservableList<PomodoroSession> sessionData = FXCollections.observableArrayList(mainController.loadSessionsFromDB());
        view.showData(sessionData);
    }

}
