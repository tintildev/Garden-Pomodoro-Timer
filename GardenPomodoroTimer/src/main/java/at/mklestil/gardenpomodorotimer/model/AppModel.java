package at.mklestil.gardenpomodorotimer.model;

public class AppModel {
    private String selectedPlant = "start";
    private int time = 25;
    private String tag = "lernen";

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
}
