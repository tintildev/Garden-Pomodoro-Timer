package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.App;
import at.mklestil.gardenpomodorotimer.model.AppModel;
import at.mklestil.gardenpomodorotimer.model.ImageViewWithPath;
import at.mklestil.gardenpomodorotimer.view.ChosePlant;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

        registerEventHandler();



    }

    private void registerEventHandler() {
        imageViewHandler();

        startButtonHandler();
    }

    private void imageViewHandler(){
        ArrayList<ImageViewWithPath> images = view.getListOfImageViews();
        System.out.println("Size of images: " + images.size());
        for(ImageViewWithPath image: images){
            image.getImageView().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
                view.setChose(image.getPath());
                System.out.println("Chose set: " + image.getPath());
            });
        }
    }

    private void startButtonHandler(){
        view.getStartBtn().addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            model.setSelectedPlant(view.getChose());
            model.setTag(view.getTagChose());
            model.setTime(view.getTimeChose());
            System.out.println("chosen values: " + view.getChose() + " " +  view.getTagChose()+ " " + view.getTimeChose());
            mainController.switchTo("start");
        });
    }


}
