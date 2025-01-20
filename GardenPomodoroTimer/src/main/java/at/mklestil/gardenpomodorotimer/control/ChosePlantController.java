package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.view.ChosePlant;

public class ChosePlantController {
    private final ChosePlant viewChosePlant;

    private final SceneManger sceneManger;


    public ChosePlantController(ChosePlant view, SceneManger scene){
        viewChosePlant = view;
        sceneManger = scene;
    }

}
