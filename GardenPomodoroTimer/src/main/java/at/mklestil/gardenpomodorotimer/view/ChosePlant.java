package at.mklestil.gardenpomodorotimer.view;

import at.mklestil.gardenpomodorotimer.model.ImageViewWithPath;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;

/**
 * ChosePlant View, a view to chose a plant.
 */

public class ChosePlant {
    private VBox root;
    private String chose = "/images/start/start.png";
    private int timeChose = 25;
    private String tagChose = "learn";
    private ArrayList<String> plantList;
    private Image plantImage;
    private ArrayList<ImageViewWithPath> listOfImageViews = new ArrayList<>();

    private Button startBtn;

    public ChosePlant(){
        root = new VBox();
        FlowPane plantContainer = getPlantContainer();
        FlowPane fokusTimeContainer = getFocusTimeContainer();
        HBox tagsContainer = getTagsContainer(new ArrayList<String>());
        FlowPane choseContainer = getChoseContainer();

        root.getChildren().add(plantContainer);
        root.getChildren().add(fokusTimeContainer);
        root.getChildren().add(tagsContainer);
        root.getChildren().add(choseContainer);

    }

    private FlowPane getPlantContainer(){
        FlowPane plantContainer = new FlowPane();
        plantList = new ArrayList<>();
        //Todo:: dynamic plants form db
        plantList.add("/images/tree/6_tree.png");
        plantList.add("/images/tree/fall.png");
        plantList.add("/images/tree/greenLeaves.png");
        plantList.add("/images/tree/pointedTree.png");
        plantList.add("/images/tree/roundTree.png");


        for(String name : plantList){
            InputStream inputStream1 = getClass().getResourceAsStream(name);
            Image plantImg1 = new Image(inputStream1);
            ImageView plantView1 = new ImageView(plantImg1);
            plantView1.setFitWidth(50);
            plantView1.setFitHeight(50);
            listOfImageViews.add(new ImageViewWithPath(plantView1, name));
            plantContainer.getChildren().add(plantView1);
        }

        return plantContainer;
    }

    private FlowPane getChoseContainer (){
        //Todo:: Data from db
        FlowPane choseContainer = new FlowPane();
        /*
        Label timeLabel = new Label("+" + timeChose);
        Label tagLabel = new Label(tagChose);
        timeLabel.getStyleClass().add("label");
        tagLabel.getStyleClass().add("label");
        InputStream inputStream = getClass().getResourceAsStream("/images/start/start.png");
        plantImage = new Image(inputStream);
        ImageView imageView = new ImageView(plantImage);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.getStyleClass().add("image-view");


        choseContainer.getStyleClass().add("root");
        choseContainer.getChildren().add(timeLabel);
        choseContainer.getChildren().add(imageView);
        choseContainer.getChildren().add(tagLabel);
        */
        startBtn = new Button("start");
        startBtn.getStyleClass().add("start-button");
        choseContainer.getChildren().add(startBtn);

        return choseContainer;
    }

    private FlowPane getFocusTimeContainer (){
        FlowPane timesContainer = new FlowPane();
        ArrayList<Integer> times = new ArrayList<Integer>();
        times.add(10);
        times.add(15);
        times.add(25);
        times.add(30);
        times.add(50);
        times.add(60);
        times.add(90);
        times.add(120);
        for(Integer number : times){
            Button tempTimeLabel = new Button("" + number);
            tempTimeLabel.getStyleClass().add("button");
            tempTimeLabel.setMinSize(40, 30);
            tempTimeLabel.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
                timeChose = number;
            });
            timesContainer.getChildren().add(tempTimeLabel);
        }
        timesContainer.getStyleClass().add("container");

        return timesContainer;
    }

    private HBox getTagsContainer(ArrayList<String> tagsList){
        //Todo:: Data from db
        HBox tagsContainer = new HBox();
        if(tagsList.size() == 0 || tagsList == null){
            tagsContainer.getChildren().add(new Label("no tag"));
        }else{
            for(String tags : tagsList){
                Label temp = new Label(tags);
                tagsContainer.getChildren().add(temp);
            }
        }
        tagsContainer.getStyleClass().add("container");
        return tagsContainer;
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

    public Button getStartBtn(){
        return startBtn;
    }

    public String getChose() {
        return chose;
    }

    public void setChose(String chose) {
        this.chose = chose;
    }

    public int getTimeChose() {
        return timeChose;
    }

    public void setTimeChose(int timeChose) {
        this.timeChose = timeChose;
    }

    public String getTagChose() {
        return tagChose;
    }

    public void setTagChose(String tagChose) {
        this.tagChose = tagChose;
    }

    public ArrayList<ImageViewWithPath> getListOfImageViews() {
        return listOfImageViews;
    }
}
