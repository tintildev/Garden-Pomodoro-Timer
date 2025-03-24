package at.mklestil.gardenpomodorotimer.view;

import at.mklestil.gardenpomodorotimer.model.PomodoroSession;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ChartView {
    private VBox root;
    private Button backBtn = new Button("Start");
    private TableView tableView = new TableView();

    public ChartView(){
        root = new VBox();
        root.getChildren().addAll(tableView, backBtn);

    }

    public void showData(ObservableList<PomodoroSession> sessionData) {
        System.out.println(sessionData);
        TableColumn<PomodoroSession, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<PomodoroSession, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<PomodoroSession, String> plantColumn = new TableColumn<>("Plant");
        plantColumn.setCellValueFactory(new PropertyValueFactory<>("plantChoice"));

        TableColumn<PomodoroSession, String> timestampColumn = new TableColumn<>("Timestamp");
        timestampColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        // Spalten zur TableView hinzufügen
        tableView.getColumns().addAll(idColumn, durationColumn, plantColumn, timestampColumn);
        tableView.setItems(sessionData);
        tableView.refresh();
    }

    public VBox getRoot() {
        return root;
    }

    public Button getBackBtn() {
        return backBtn;
    }
}
