package at.mklestil.gardenpomodorotimer.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.InputStream;
import java.util.ArrayList;

public class StartWindow {
    private BorderPane root;
    private Label status;
    private Button plus = new Button("+");
    private Button minus = new Button("-");
    private ProgressBar progress;
    private Label learnTag = new Label("");
    private Button startButton = new Button("Start");
    private Button breakButton = new Button("Break");
    private Button resetButton = new Button("Rest");
    private Label timeLabel;
    private final Image[] plantStages = new Image[6];
    private ImageView plantImageView;

    public StartWindow() {
        root = new BorderPane();

        //Timer
        VBox vBox = new VBox(5);
        HBox hbox = new HBox(5);
        startTree();
        plantImageView = new ImageView(plantStages[0]);
        plantImageView.setFitWidth(150);
        plantImageView.setFitHeight(150);
        progress = new ProgressBar();
        hbox.getChildren().addAll(plus, progress, minus);
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(startButton, breakButton, resetButton);
        vBox.getChildren().addAll(plantImageView, learnTag, hbox, buttonBox);

        //Status and Time
        status = new Label("Ready to start!");
        timeLabel = new Label("25:00");

        //Add root
        root.setTop(status);
        root.setCenter(vBox);
        root.setBottom(timeLabel);

        //Center Elements
        hbox.setStyle("-fx-alignment: center;");
        buttonBox.setStyle("-fx-alignment: center;");
        vBox.setStyle("-fx-alignment: center;");
        BorderPane.setAlignment(status, Pos.CENTER);
        BorderPane.setAlignment(timeLabel, Pos.CENTER);

        // create Background
        BackgroundFill backgroundFill = new BackgroundFill(
                Color.web("#55C57A"),  // color
                null,  // Ecken (CornerRadii)
                null   // Rand (Insets)
        );

        // CSS Classes
        learnTag.getStyleClass().add("tagLabel");
        status.getStyleClass().add("statusLabel");
        timeLabel.getStyleClass().add("timeLabel");

        // set Background
        root.setBackground(new Background(backgroundFill));

        // disable
        breakButton.setDisable(true);
    }

    public void startTree(){
        InputStream inputStream = getClass().getResourceAsStream("/images/start/start.png");
        if(inputStream != null){
            //Check Image is correct
            Image image = new Image(inputStream);
            if(!image.isError()){
                plantStages[0] = image;
            }else {
                System.out.println("Error loading image: " + "/images/start/start.png");
            }
        }else{
            System.out.println("Image file not found.");
        }
    }

    public void initialTrees(ArrayList<String> listImagePath){
        ArrayList<String> imagePath = new ArrayList<>();
        imagePath = listImagePath;
        if(listImagePath.size() == 0){
            //Image Path, in the future delete hard codes
            imagePath.add("/images/start/start.png");
            imagePath.add("/images/start/start.png");
            imagePath.add("/images/start/start.png");
            imagePath.add("/images/start/start.png");
            imagePath.add("/images/start/start.png");
            imagePath.add("/images/start/start.png");
        }
        // Add img plantStages
        for (int i = 0; i < imagePath.size(); i++){
            //Check Stream Path
            InputStream inputStream = getClass().getResourceAsStream(imagePath.get(i));
            if(inputStream != null){
                //Check Image is correct
                Image image = new Image(inputStream);
                if(!image.isError()){
                    plantStages[i] = image;
                }else {
                    System.out.println("Error loading image: " + imagePath.get(i));
                }
            }else{
                System.out.println("Image file not found.");
            }
        }

    }

    public BorderPane getRoot() {
        return root;
    }

    public Label getStatus() {
        return status;
    }

    public Button getPlus() {
        return plus;
    }

    public Button getMinus() {
        return minus;
    }

    public ProgressBar getProgress() {
        return progress;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getBreakButton() {
        return breakButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Image[] getPlantStages() {
        return plantStages;
    }

    public ImageView getPlantImageView() {
        return plantImageView;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setPlantImageView(ImageView plantImageView) {
        this.plantImageView = plantImageView;
    }

    public Label getLearnTag() {
        return learnTag;
    }

    public void setLearnTag(Label learnTag) {
        this.learnTag = learnTag;
    }
}
