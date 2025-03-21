package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.view.ChartView;

public class ChartController {
    private MainController mainController;
    private ChartView view;

    public ChartController(MainController mainController, ChartView view){
        this.view = view;
        this.mainController = mainController;
        this.view.getBackBtn().setOnAction(event -> {
            mainController.switchTo("start");
        });
    }
}
