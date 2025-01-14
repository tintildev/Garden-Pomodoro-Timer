package at.mklestil.gardenpomodorotimer.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class ChosePlant {
    private VBox root;
    private String chose;
    private int timeChose = 25;
    private String tagChose = "learn";
    private ArrayList<String> listOfPlants;
    private Image plantImage;

    public ChosePlant(){
        root = new VBox();
        FlowPane plantContainer = new FlowPane();
        HBox fokusTimeContainer = new HBox();
        HBox tagsContainer = new HBox();
        FlowPane choseContainer = getChoseContainer();

        root.getChildren().add(plantContainer);
        root.getChildren().add(fokusTimeContainer);
        root.getChildren().add(tagsContainer);
        root.getChildren().add(choseContainer);

    }

    private FlowPane getChoseContainer (){
        FlowPane choseContainer = new FlowPane();
        Label timeLabel = new Label("+" +timeChose);
        Label tagLabel = new Label(tagChose);
        InputStream inputStream = getClass().getResourceAsStream("/images/start/start.png");
        plantImage = new Image(inputStream);
        ImageView imageView = new ImageView(plantImage);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Button startBtn = new Button("start");
        choseContainer.getChildren().add(timeLabel);
        choseContainer.getChildren().add(imageView);
        choseContainer.getChildren().add(tagLabel);
        choseContainer.getChildren().add(startBtn);

        return choseContainer;
    }

    private void showListOfTrees(){
        //Todo:: Trees load
    }

    private void showListOfTags(){
        //Todo:: tags lod
    }

    public VBox getRoot() {
        return root;
    }

    public void setListOfPlants(ArrayList<String> list){
        listOfPlants = list;
    }

    public ArrayList<String> getListOfPlants(){
        return listOfPlants;
    }
}
