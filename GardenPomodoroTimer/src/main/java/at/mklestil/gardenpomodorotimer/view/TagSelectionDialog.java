package at.mklestil.gardenpomodorotimer.view;

import javafx.scene.control.ChoiceDialog;

import java.util.List;
import java.util.Optional;

public class TagSelectionDialog extends ChoiceDialog<String> {
    /**
     * Shows a dialog to select a tag from the provided list.
     *
     * @param tags List of tags to choose from.
     * @return An Optional containing the selected tag, or empty if no selection was made.
     */
    public TagSelectionDialog(List<String> tags) {
        //Todo: LanguageManager
        super(tags.get(0), tags);
        this.setTitle("Tag auswählen");
        this.setHeaderText("Wähle einen Tag für deine Session:");
        this.setContentText("Tag:");
    }

    public Optional<String> show(List<String> tags) {
        return this.showAndWait();

    }
}
