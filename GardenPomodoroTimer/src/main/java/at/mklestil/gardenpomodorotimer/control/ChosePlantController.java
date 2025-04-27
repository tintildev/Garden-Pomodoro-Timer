package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.App;
import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class ChosePlantController {
    private final ChosePlant view;

    private final MainController mainController;
    private ArrayList<String> listOfPlants;
    private Image plantImage;
    private AppModel model;


    public ChosePlantController(ChosePlant viewChosePlant, MainController scene){
        view = viewChosePlant;
        mainController = scene;
        model = mainController.getModel();


        view.getStartBtn().addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            model.setSelectedPlant(view.getChose());
            model.setTag(view.getTagChose());
            model.setTime(view.getTimeChose());
            System.out.println("chosen values: " + view.getChose() + " " +  view.getTagChose()+ " " + view.getTimeChose());
            mainController.switchTo("start");
        });
    }

}
