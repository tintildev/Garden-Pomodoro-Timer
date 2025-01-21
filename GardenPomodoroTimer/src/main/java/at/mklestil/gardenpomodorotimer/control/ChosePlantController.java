package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class ChosePlantController {
    private final ChosePlant view;

    private final SceneManger sceneManger;

    private String chose = "";
    private int timeChose = 25;
    private String tagChose = "learn";
    private ArrayList<String> listOfPlants;
    private Image plantImage;


    public ChosePlantController(ChosePlant viewChosePlant, SceneManger scene){
        view = viewChosePlant;
        sceneManger = scene;


        view.getStartBtn().addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            sceneManger.switchTo("start");

            //TODO:: data to MyController

        });
    }

}
