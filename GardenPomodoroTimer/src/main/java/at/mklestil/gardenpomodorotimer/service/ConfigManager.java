package at.mklestil.gardenpomodorotimer.service;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * ConfigManager, reads the language from the config.properties and saves it.
 */
public class ConfigManager {
    private static final String CONFIG_FILE = "properties/config.properties";
    private Properties properties;

    /**
     * Create congifmanger and call the load config method.
     */
    public ConfigManager() {
        properties = new Properties();
        loadConfig();
    }

    /**
     * load the configs form config file.
     */
    private void loadConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            System.out.println("Error by load the properties: " + e.getMessage());
        }
    }

    public HashMap<String, String> getLanguage() {
        //HashMap for language and region
        HashMap<String, String> propertyLanguageData = new HashMap<String, String>();
        propertyLanguageData.put("language", properties.getProperty("language", "de"));
        return propertyLanguageData;
    }

    public void setLanguage(String language) {
        properties.setProperty("language", language);
        saveConfig();
        LanguageManager.getInstance().changeLanguage(language);
    }

    private void saveConfig() {
        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            System.out.println("Error by save the config: " + e.getMessage());
        }
    }
}
