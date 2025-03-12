package at.mklestil.gardenpomodorotimer.view;

import at.mklestil.gardenpomodorotimer.service.LanguageManager;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class SettingsView {
    //Todo: Work on SettingsView
    //Todo: update UI, Observer, listerners

    private VBox root = new VBox();
    private ComboBox<String> languageBox;

    public SettingsView(){
        FlowPane flowPane = new FlowPane();
        languageBox = new ComboBox<>();
        languageBox.getItems().addAll("English", "Deutsch");
        languageBox.setValue(LanguageManager.getInstance().getBundle().getString("language"));

        Label infoLabel = new Label("Chose Language:");
        flowPane.getChildren().addAll(infoLabel, languageBox);
        root.getChildren().addAll(flowPane);
    }

    public VBox getRoot() {
        return root;
    }
}


