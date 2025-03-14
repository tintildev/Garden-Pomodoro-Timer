package at.mklestil.gardenpomodorotimer.service;

import at.mklestil.gardenpomodorotimer.model.AppModel;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * central singleton object that holds the language and informs listeners when the language changes
 */
public class LanguageManager {
    private static LanguageManager instance;
    private ResourceBundle bundle;
    /*
    * Runnable is a list of functions that are automatically executed when the language is changed.
     */
    private final List<Runnable> listeners = new ArrayList<>();
    private Locale currentLocale;
    private AppModel model = AppModel.getInstance();

    private LanguageManager() {
        // JDK 19 use Locale.Builder
        setLocale(model.getCurrentLanguage());
    }

    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }

    private void loadLanguage() {
        this.bundle = ResourceBundle.getBundle("lang.messages", currentLocale);
        System.out.println("Loadet language: " + bundle.getString("language"));
        notifyListeners();

    }

    public void setLocale(String languageCode) {
        model.setCurrentLanguage(languageCode);
        currentLocale = new Locale.Builder()
                .setLanguage(languageCode)
                .build();
        System.out.println("setLocale - Language: " + languageCode);
        //set locale, model and load new language in ui (notifyListeners)
        Locale.setDefault(currentLocale);
        model.setCurrentLanguage(languageCode);
        loadLanguage();

    }

    private void notifyListeners() {
        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    public void addLanguageChangeListener(Runnable listener) {
        listeners.add(listener);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }


}


