package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.service.LanguageManager;
import at.mklestil.gardenpomodorotimer.view.SettingsView;

public class SettingsController {
    private SettingsView view;
    private MainController mainController;
    public SettingsController(SettingsView view, MainController mainController) {
        this.view = view;
        this.mainController = mainController;

        changeLanguage();
        changeScene();

    }

    private void changeScene() {
        view.getBackBtn().setOnAction(event -> {
            mainController.switchTo("start");
        });
    }

    private void changeLanguage() {
        view.getLanguageBox().setOnAction(event -> {
            System.out.println("change Language: " + view.getLanguageBox().getValue());
            LanguageManager.getInstance().setLocale(view.getLanguageBox().getValue());
        });
    }

}
