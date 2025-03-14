package at.mklestil.gardenpomodorotimer.view;

import at.mklestil.gardenpomodorotimer.service.LanguageManager;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class SettingsView {

    private VBox root = new VBox();
    private ComboBox<String> languageBox;
    private Button backBtn = new Button("Start");

    public SettingsView(){
        FlowPane flowPane = new FlowPane();
        languageBox = new ComboBox<>();
        languageBox.getItems().addAll("en", "de");
        languageBox.setValue(LanguageManager.getInstance().getBundle().getString("language"));

        Label infoLabel = new Label("Chose Language:");
        flowPane.getChildren().addAll(infoLabel, languageBox);
        root.getChildren().addAll(flowPane, backBtn);


    }

    public VBox getRoot() {
        return root;
    }

    public ComboBox<String> getLanguageBox() {
        return languageBox;
    }

    public Button getBackBtn() {
        return backBtn;
    }
}


