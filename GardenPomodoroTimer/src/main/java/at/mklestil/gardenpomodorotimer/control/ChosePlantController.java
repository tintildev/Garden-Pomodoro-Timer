package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class ChosePlantController {
    private final ChosePlant view;

    private final MainController mainController;

    private String chose = "";
    private int timeChose = 25;
    private String tagChose = "learn";
    private ArrayList<String> listOfPlants;
    private Image plantImage;


    public ChosePlantController(ChosePlant viewChosePlant, MainController scene){
        view = viewChosePlant;
        mainController = scene;


        view.getStartBtn().addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            mainController.switchTo("start");
            mainController.setChose(chose);
            mainController.setTagChose(chose);
            mainController.setTimeChose(timeChose);


        });
    }

}
