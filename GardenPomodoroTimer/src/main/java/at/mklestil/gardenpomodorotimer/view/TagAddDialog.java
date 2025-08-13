package at.mklestil.gardenpomodorotimer.view;

import at.mklestil.gardenpomodorotimer.service.LanguageManager;
import javafx.scene.control.TextInputDialog;

/**
 * This class represents a dialog for adding tags to the application.
 */
public class TagAddDialog extends TextInputDialog {

    public TagAddDialog(){
        this.setTitle(LanguageManager.getInstance().getBundle().getString("addTagTitle"));
        this.setHeaderText(LanguageManager.getInstance().getBundle().getString("addTagHeader"));
    }


}
