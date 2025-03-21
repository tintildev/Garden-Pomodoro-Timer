package at.mklestil.gardenpomodorotimer.view;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ChartView {
    private VBox root;
    private Button backBtn = new Button("Start");

    public ChartView(){
        root = new VBox();
        TableView tableView = new TableView();
        root.getChildren().addAll(tableView, backBtn);

    }

    public VBox getRoot() {
        return root;
    }

    public Button getBackBtn() {
        return backBtn;
    }
}
