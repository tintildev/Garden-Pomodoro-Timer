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

public class MainWindow {
    private BorderPane root;
    private Label status;
    private Button plus = new Button("+");
    private Button minus = new Button("-");
    private ProgressBar progress;
    private Button startButton = new Button("Start");
    private Button breakButton = new Button("Break");
    private Button resetButton = new Button("Rest");
    private Label time;
    private final Image[] plantStages = new Image[6];
    private ImageView plantImageView;

    public MainWindow() {
        root = new BorderPane();

        //Timer
        VBox vBox = new VBox(5);
        HBox hbox = new HBox(5);
        initialTrees();
        plantImageView = new ImageView(plantStages[0]);
        plantImageView.setFitWidth(150);
        plantImageView.setFitHeight(150);
        progress = new ProgressBar();
        hbox.getChildren().addAll(plus, progress, minus);
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(startButton, breakButton, resetButton);
        vBox.getChildren().addAll(plantImageView, hbox, buttonBox);


        //Status and Time
        status = new Label("Ready to start!");
        status.setFont(Font.font("Roboto", 20));
        status.setTextFill(Color.WHITE);
        time = new Label("25:00");
        time.setFont(new Font("Roboto", 40));
        time.setTextFill(Color.WHITE);

        //Add root
        root.setTop(status);
        root.setCenter(vBox);
        root.setBottom(time);

        //Center Elements
        hbox.setStyle("-fx-alignment: center;");
        buttonBox.setStyle("-fx-alignment: center;");
        vBox.setStyle("-fx-alignment: center;");
        BorderPane.setAlignment(status, Pos.CENTER);
        BorderPane.setAlignment(time, Pos.CENTER);

        // create Background
        BackgroundFill backgroundFill = new BackgroundFill(
                Color.web("#55C57A"),  // color
                null,  // Ecken (CornerRadii)
                null   // Rand (Insets)
        );

        // set Background
        root.setBackground(new Background(backgroundFill));

    }

    public void initialTrees(){
        //Image Path, in the future delete hard code
        ArrayList<String> imagePath = new ArrayList<>();
        imagePath.add("/images/start.png");
        imagePath.add("/images/1_tree.png");
        imagePath.add("/images/2_tree.png");
        imagePath.add("/images/3_tree.png");
        imagePath.add("/images/4_tree.png");
        imagePath.add("/images/5_tree.png");

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

    public Label getTimeLabel() {
        return time;
    }

    public Image[] getPlantStages() {
        return plantStages;
    }

    public ImageView getPlantImageView() {
        return plantImageView;
    }

    public void setPlantImageView(ImageView plantImageView) {
        this.plantImageView = plantImageView;
    }
}
