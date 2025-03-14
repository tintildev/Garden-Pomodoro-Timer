package at.mklestil.gardenpomodorotimer.model;

import at.mklestil.gardenpomodorotimer.service.LanguageManager;

/**
 * AppModel local data
 */
public class AppModel {
    private String selectedPlant = "start";
    private int time = 25;
    private String tag = "lernen";
    private String currentLanguage = "de";
    private static AppModel instance;

    private AppModel() {

    }

    public static AppModel getInstance() {
        if (instance == null) {
            instance = new AppModel();
        }
        return instance;
    }

    public String getSelectedPlant() {
        return selectedPlant;
    }

    public void setSelectedPlant(String selectedPlant) {
        this.selectedPlant = selectedPlant;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String language) {
        this.currentLanguage = language;
    }


}
