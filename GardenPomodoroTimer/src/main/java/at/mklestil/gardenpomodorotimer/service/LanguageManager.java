package at.mklestil.gardenpomodorotimer.service;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * central singleton object that holds the language and informs listeners when the language changes
 */
public class LanguageManager {
    private static LanguageManager instance;
    private ResourceBundle bundle;
    private final List<Runnable> listeners = new ArrayList<>();
    private static Locale currentLocale = new Locale.Builder()
            .setLanguage("de")
            .build();

    private LanguageManager() {
        // JDK 19 use Locale.Builder
        loadLanguage(new ConfigManager().getLanguage());
    }

    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }

    private void loadLanguage(HashMap<String, String> language) {
        setLocale(language.get("language"));
        this.bundle = ResourceBundle.getBundle("lang.messages", currentLocale);
        System.out.println("Loadet language: " + bundle.getString("language"));
        notifyListeners();
        /**
         * Search properties
         *   System.out.println("Current Locale: " + currentLocale);
         *         InputStream stream = getClass().getResourceAsStream("/lang/messages_de.properties");
         *         System.out.println(stream);
         *         URL resourceUrl = getClass().getResource("/lang/messages.properties");
         *         System.out.println("Resource URL: " + resourceUrl);
         */

    }

    public static void setLocale(String languageCode) {
        currentLocale = new Locale.Builder()
                .setLanguage(languageCode)
                .build();
        Locale.setDefault(currentLocale);

    }

    private void notifyListeners() {
        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    public void addLanguageChangeListener(Runnable listener) {
        listeners.add(listener);
    }

    public static Locale getLocale() {
            return currentLocale;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void changeLanguage(String newLanguageCode) {
        ConfigManager configManager = new ConfigManager();
        configManager.setLanguage(newLanguageCode); // Sprache in der Config speichern
        loadLanguage(configManager.getLanguage()); // Neue Sprache laden
    }


}


