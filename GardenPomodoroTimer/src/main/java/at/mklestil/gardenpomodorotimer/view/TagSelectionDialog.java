package at.mklestil.gardenpomodorotimer.view;

import javafx.scene.control.ChoiceDialog;

import java.util.List;
import java.util.Optional;

public class TagSelectionDialog {
    /**
     * Shows a dialog to select a tag from the provided list.
     *
     * @param tags List of tags to choose from.
     * @return An Optional containing the selected tag, or empty if no selection was made.
     */

    public Optional<String> show(List<String> tags) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(tags.get(0), tags);
        dialog.setTitle("Tag auswählen");
        dialog.setHeaderText("Wähle einen Tag für deine Session:");
        dialog.setContentText("Tag:");

        return dialog.showAndWait();

    }
}
