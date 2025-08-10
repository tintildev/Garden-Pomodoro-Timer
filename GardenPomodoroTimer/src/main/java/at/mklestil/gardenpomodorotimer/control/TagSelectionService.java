package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.model.AppModel;

import java.util.List;

public class TagSelectionService {

    private final MainController mainController;
    private final AppModel model;

    public TagSelectionService(MainController mainController, AppModel model) {
        this.mainController = mainController;
        this.model = model;
    }

    /**
     * Method to get the available tags from the database.
     */
    public List<String> getAvailableTags() {
        List<String> tags = mainController.loadTagsFromDB();

        if (tags.isEmpty()) {
            tags.add(model.getTag());
        }

        return tags;
    }
}
